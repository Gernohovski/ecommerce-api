package br.com.fatecmogi.model.entity.pedido;

import br.com.fatecmogi.model.entity.livro.Livro;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection
public class ItemPedido {

	private Long id;

	private Livro livro;

	private Carrinho carrinho;

	private Integer quantidade;

	private boolean trocaAberta;

	private boolean devolucaoAberta;

	private BigDecimal valor;

}
