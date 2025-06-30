package br.com.fatecmogi.controller.dto.chatBot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecomendacaoRepostaDTO {

	private String mensagem;

	private int status;

	private Long livroId;

}
