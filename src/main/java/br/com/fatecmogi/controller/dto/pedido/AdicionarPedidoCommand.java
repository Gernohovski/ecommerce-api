package br.com.fatecmogi.controller.dto.pedido;

import br.com.fatecmogi.model.entity.cartaoCredito.CartaoCredito;
import br.com.fatecmogi.model.entity.cliente.Cliente;
import br.com.fatecmogi.model.entity.endereco.EnderecoResidencial;
import br.com.fatecmogi.model.entity.pedido.Carrinho;
import br.com.fatecmogi.model.entity.pedido.SituacaoPedido;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;
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

}
