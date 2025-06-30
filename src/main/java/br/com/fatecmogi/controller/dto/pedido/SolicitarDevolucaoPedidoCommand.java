package br.com.fatecmogi.controller.dto.pedido;

import br.com.fatecmogi.model.entity.pedido.ItemDevolucao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class SolicitarDevolucaoPedidoCommand {

	private Long pedidoId;

	private List<ItemDevolucao> item;

}
