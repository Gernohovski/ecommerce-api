package br.com.fatecmogi.model.entity.pedido;

import br.com.fatecmogi.model.entity.cartaoCredito.CartaoCredito;
import br.com.fatecmogi.model.entity.cliente.Cliente;
import br.com.fatecmogi.model.entity.endereco.EnderecoResidencial;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection
public class Pedido {

	private Long id;

	private SituacaoPedido situacaoPedido;

	private Carrinho carrinho;

	private LocalDate dataPedido;

	private EnderecoResidencial endereco;

	private List<CartaoCredito> cartoesCredito;

	private Cliente cliente;

}
