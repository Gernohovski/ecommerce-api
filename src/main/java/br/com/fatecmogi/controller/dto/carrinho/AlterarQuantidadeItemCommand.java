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
public class AlterarQuantidadeItemCommand {

	@NotNull(message = "O item a ser trocada a quantidade é obrigatório.")
	Long itemId;

	@NotBlank(message = "A quantidade de itens é obrigatória")
	Integer quantidade;

}
