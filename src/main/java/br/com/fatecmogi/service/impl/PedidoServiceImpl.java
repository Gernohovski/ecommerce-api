package br.com.fatecmogi.service.impl;

import br.com.fatecmogi.controller.dto.pedido.AdicionarPedidoCommand;
import br.com.fatecmogi.controller.mapper.PedidoMapper;
import br.com.fatecmogi.model.entity.pedido.Pedido;
import br.com.fatecmogi.model.exception.itemCarrinho.CarrinhoNaoEncontradoException;
import br.com.fatecmogi.model.repository.CarrinhoRepository;
import br.com.fatecmogi.model.repository.PedidoRepository;
import br.com.fatecmogi.service.PedidoService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class PedidoServiceImpl implements PedidoService {

	@Inject
	PedidoRepository pedidoRepository;

	@Inject
	CarrinhoRepository carrinhoRepository;

	@Inject
	PedidoMapper pedidoMapper;

	@Override
	@Transactional
	public Pedido cadastrarPedido(AdicionarPedidoCommand command) {
		var pedido = pedidoMapper.from(command);
		var carrinho = carrinhoRepository.buscar(command.getCarrinhoId()).orElseThrow(CarrinhoNaoEncontradoException::new);
		carrinho.setComprado(true);
		carrinhoRepository.atualizar(carrinho);
		return pedidoRepository.save(pedido);
	}

	@Override
	@Transactional
	public List<Pedido> listarPedidosCliente(Long clienteId) {
		return pedidoRepository.findAllByClienteId(clienteId);
	}

}
