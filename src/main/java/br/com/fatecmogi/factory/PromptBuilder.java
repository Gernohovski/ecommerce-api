package br.com.fatecmogi.factory;

import br.com.fatecmogi.controller.dto.chatBot.SolicitarRecomendacaoCommand;
import br.com.fatecmogi.model.entity.livro.Categoria;
import br.com.fatecmogi.model.entity.livro.Livro;
import br.com.fatecmogi.model.entity.pedido.ItemPedido;
import br.com.fatecmogi.model.entity.pedido.Pedido;
import br.com.fatecmogi.model.exception.erroInternoException.ErroInternoException;
import br.com.fatecmogi.service.LivroService;
import br.com.fatecmogi.service.PedidoService;
import br.com.fatecmogi.service.impl.RedisService;
import com.openai.models.ChatModel;
import com.openai.models.chat.completions.ChatCompletionCreateParams;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.Builder;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

@ApplicationScoped
public class PromptBuilder {

	@Inject
	private RedisService redisService;

	@Inject
	private LivroService livroService;

	@Inject
	private PedidoService pedidoService;

	@Builder(builderMethodName = "builder")
	public ChatCompletionCreateParams createPrompt(SolicitarRecomendacaoCommand command,
			List<String> historicoDeMensagens) {
		List<String> ultimasMensagens = historicoDeMensagens.subList(Math.max(0, historicoDeMensagens.size() - 3),
				historicoDeMensagens.size());
		return ChatCompletionCreateParams.builder()
			.addSystemMessage("Instruções: " + carregarPromptRecomendacao())
			.addSystemMessage("Formato de resposta: " + carregarPromptRespostaPadrao())
			.addSystemMessage("Livros disponíveis em estoque:" + getLivrosEstoque())
			.addSystemMessage("Histórico de pedidos do cliente (solicite mais informações se vazio): "
					+ getPedidosCliente(command.getClienteId()))
			.addUserMessage("Histórico de mensagens anteriores:" + ultimasMensagens)
			.addUserMessage("Mensagem atual do usuário (deve responder apenas a esta)" + command.getPergunta())
			.model(ChatModel.GPT_4O)
			.build();
	}

	private String carregarPromptRecomendacao() {
		try {
			var uri = Objects.requireNonNull(getClass().getClassLoader().getResource("recomendacao-system-message.txt"))
				.toURI();
			return Files.readString(Paths.get(uri), StandardCharsets.UTF_8);
		}
		catch (Exception e) {
			throw new ErroInternoException();
		}
	}

	private String carregarPromptRespostaPadrao() {
		try {
			var uri = Objects.requireNonNull(getClass().getClassLoader().getResource("general-dev-message.txt"))
				.toURI();
			return Files.readString(Paths.get(uri), StandardCharsets.UTF_8);
		}
		catch (Exception e) {
			throw new ErroInternoException();
		}
	}

	private String getLivrosEstoque() {
		var livros = livroService.buscarTodos();
		StringBuilder sb = new StringBuilder();
		for (Livro livro : livros) {
			sb.append("Livro - ").append(livro.getId());
			sb.append("Título: ").append(livro.getTitulo());
			sb.append("Categorias: ");
			for (Categoria categoria : livro.getCategorias()) {
				sb.append(categoria.getNome()).append(",");
			}
			sb.append("Sinopse: ").append(livro.getSinopse());
		}
		return sb.toString();
	}

	private String getPedidosCliente(Long clienteId) {
		var pedidos = pedidoService.listarPedidosCliente(clienteId);
		StringBuilder sb = new StringBuilder();
		for (Pedido pedido : pedidos) {
			sb.append("Pedido - ").append(pedido.getId());
			for (ItemPedido itemPedido : pedido.getItensPedido()) {
				var livro = itemPedido.getLivro();
				sb.append("Livro - ").append(livro.getId());
				sb.append("Título: ").append(livro.getTitulo());
				sb.append("Categorias: ");
				for (Categoria categoria : livro.getCategorias()) {
					sb.append(categoria.getNome()).append(",");
				}
				sb.append("Sinopse: ").append(livro.getSinopse());
			}
		}
		return sb.toString();
	}

}
