package br.com.fatecmogi.controller.dto.pedido;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class SolicitarTrocaPedidoCommand {

	private Long id;

	private List<String> itensId;

}
