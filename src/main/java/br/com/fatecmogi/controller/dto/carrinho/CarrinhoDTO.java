package br.com.fatecmogi.controller.dto.carrinho;

import br.com.fatecmogi.model.entity.pedido.ItemCarrinho;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class CarrinhoDTO {

	private Long id;

	private List<ItemCarrinho> itens;

	private String dataExpiracao;

	private String dataCriacao;

	private boolean comprado;

}
