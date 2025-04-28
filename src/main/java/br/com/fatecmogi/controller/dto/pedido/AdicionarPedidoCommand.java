package br.com.fatecmogi.controller.dto.pedido;

import br.com.fatecmogi.model.entity.cupom.CupomTroca;
import br.com.fatecmogi.model.entity.pedido.ItemPedido;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class AdicionarPedidoCommand {

	@NotNull(message = "O identificador único do carrinho da compra é obrigatório.")
	private Long carrinhoId;

	@NotNull(message = "O identificador único do endereço de entrega da compra é obrigatório.")
	private Long enderecoId;

	@NotNull(message = "Os identificadores únicos dos cartões de crédito da compra são obrigatórios.")
	private List<String> cartoesCreditoId;

	@NotNull(message = "O valor da compra é obrigatório.")
	private BigDecimal valorPedido;

	@NotNull(message = "O identificador único do cliente da compra é obrigatório.")
	private Long clienteId;

	@NotNull(message = "O valor do frete é obrigatório.")
	private BigDecimal valorFrete;

	@NotEmpty(message = "Devem haver itens no pedido.")
	private List<ItemPedido> itensPedido;

	private List<CupomTroca> cuponsTroca;

}
