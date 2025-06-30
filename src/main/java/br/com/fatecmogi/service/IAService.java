package br.com.fatecmogi.service;

import br.com.fatecmogi.controller.dto.chatBot.*;

public interface IAService {

	RecomendacaoRepostaDTO gerarRecomendacao(SolicitarRecomendacaoCommand command);

	QuizRespostaDTO gerarQuiz(SolicitarQuizCommand command);

	CuriosidadeRespostaDTO gerarCuriosidade(SolicitarCuriosidadeCommand command);

	void deletarHistoricoCliente(Long clienteId);

}
