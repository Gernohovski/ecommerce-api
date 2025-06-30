package br.com.fatecmogi.service.impl;

import br.com.fatecmogi.controller.dto.chatBot.*;
import br.com.fatecmogi.factory.PromptBuilder;
import br.com.fatecmogi.model.exception.erroInternoException.ErroInternoException;
import br.com.fatecmogi.service.IAService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.chat.completions.ChatCompletion;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ApplicationScoped
public class IAServiceImpl implements IAService {

	@ConfigProperty(name = "openai.api.key")
	private String apiKey;

	private OpenAIClient client;

	@PostConstruct
	void init() {
		this.client = OpenAIOkHttpClient.builder().apiKey(apiKey).build();
	}

	@Inject
	private PromptBuilder promptBuilder;

	@Inject
	private RedisService redisService;

	@Inject
	private ObjectMapper objectMapper;

	private final String RESPOSTA_MENSAGEM_REGEX = "\\{\\s*\"mensagem\"\\s*:\\s*\"(.*?)\"\\s*,\\s*\"status\"\\s*:\\s*\\d+\\s*,\\s*\"livroId\"\\s*:\\s*(\\d+|null)\\s*\\}";

	@Override
	public RecomendacaoRepostaDTO gerarRecomendacao(SolicitarRecomendacaoCommand command) {
		List<String> historicoDeMensagens = redisService.getHistorico(command.getClienteId());
		var params = promptBuilder.builder().command(command).historicoDeMensagens(historicoDeMensagens).build();
		ChatCompletion chatCompletion = client.chat().completions().create(params);
		String respostaJson = chatCompletion.choices()
			.get(0)
			.message()
			.content()
			.orElseThrow(ErroInternoException::new);
		RecomendacaoRepostaDTO respostaRecomendacao = montarRespostaRecomendacao(respostaJson);
		atualizarHistoricoMensagens(historicoDeMensagens, respostaRecomendacao, command);
		return respostaRecomendacao;
	}

	@Override
	public void deletarHistoricoCliente(Long clienteId) {
		redisService.deletarHistoricoCliente(clienteId);
	}

	@Override
	public QuizRespostaDTO gerarQuiz(SolicitarQuizCommand command) {
		return null;
	}

	@Override
	public CuriosidadeRespostaDTO gerarCuriosidade(SolicitarCuriosidadeCommand command) {
		return null;
	}

	private void atualizarHistoricoMensagens(List<String> historicoDeMensagens,
			RecomendacaoRepostaDTO respostaRecomendacao, SolicitarRecomendacaoCommand command) {
		historicoDeMensagens.add("O cliente perguntou: " + command.getPergunta() + " e você respondeu: "
				+ respostaRecomendacao.getMensagem());
		redisService.salvarMensagemNoHistorico(command.getClienteId(), historicoDeMensagens);
	}

	private RecomendacaoRepostaDTO montarRespostaRecomendacao(String respostaJson) {
		Pattern pattern = Pattern.compile(RESPOSTA_MENSAGEM_REGEX, Pattern.DOTALL);
		Matcher matcher = pattern.matcher(respostaJson);
		if (matcher.find()) {
			try {
				String jsonEncontrado = matcher.group();
				return objectMapper.readValue(jsonEncontrado, RecomendacaoRepostaDTO.class);
			}
			catch (Exception e) {
				throw new ErroInternoException();
			}
		}
		else {
			throw new ErroInternoException();
		}
	}

}
