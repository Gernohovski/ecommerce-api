package br.com.fatecmogi.controller.dto.carrinho;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class AdicionarItemCarrinhoCommand {

	@NotNull(message = "Livro é obrigatório.")
	private Long livroId;

	@NotBlank(message = "Quantidade de livros é obrigatória.")
	private Integer quantidade;

}
