package br.com.fatecmogi.controller.dto.chatBot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SolicitarCuriosidadeCommand {

	private Long usuarioId;

	private String pergunta;

}
