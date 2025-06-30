package br.com.fatecmogi.model.entity.pedido;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection
public class ItemTroca {

	private Long id;

	private ItemPedido itemPedido;

	private int quantidade;

}
