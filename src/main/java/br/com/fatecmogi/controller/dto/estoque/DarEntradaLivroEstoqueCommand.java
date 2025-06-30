package br.com.fatecmogi.controller.dto.estoque;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DarEntradaLivroEstoqueCommand {

	@NotNull(message = "O livro deve ser informado.")
	private Long livroId;

	@Min(value = 1, message = "A quantidade mínima a ser adicionada ao estoque é um.")
	private int quantidade;

}
