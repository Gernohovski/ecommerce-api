package br.com.fatecmogi.service;

import br.com.fatecmogi.controller.dto.pedido.AdicionarPedidoCommand;
import br.com.fatecmogi.model.entity.pedido.Pedido;

import java.util.List;

public interface PedidoService {

	Pedido cadastrarPedido(AdicionarPedidoCommand command);

	List<Pedido> listarPedidosCliente(Long clienteId);

}
