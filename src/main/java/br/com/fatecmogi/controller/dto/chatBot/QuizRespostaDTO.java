package br.com.fatecmogi.controller.dto.chatBot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuizRespostaDTO {

	private String questao;

	private Map<String, String> respostasPossiveis;

}
