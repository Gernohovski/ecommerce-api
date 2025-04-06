package br.com.fatecmogi.controller.dto.carrinho;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class RemoverCarrinhoCommand {

	@NotNull(message = "O item a ser removido é obrigatório.")
	Long itemId;

}
