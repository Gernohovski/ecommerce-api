package br.com.fatecmogi.model.repository;

import br.com.fatecmogi.model.entity.pedido.Pedido;

import java.util.List;

public interface PedidoRepository {

	Pedido save(Pedido pedido);

	List<Pedido> findAllByClienteId(Long clienteId);

}
