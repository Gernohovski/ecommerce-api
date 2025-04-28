package br.com.fatecmogi.model.entity.pedido;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection
public class SolicitacaoTroca {

	private Long id;

	private Set<ItemPedido> itensPedido;

	private Pedido pedido;

}
