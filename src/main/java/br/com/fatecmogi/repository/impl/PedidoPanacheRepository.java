package br.com.fatecmogi.repository.impl;

import br.com.fatecmogi.model.entity.pedido.Pedido;
import br.com.fatecmogi.model.enums.SituacaoDoPedido;
import br.com.fatecmogi.model.repository.PedidoRepository;
import br.com.fatecmogi.repository.mapper.PanachePedidoMapper;
import br.com.fatecmogi.repository.table.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.hibernate.validator.constraints.ru.INN;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PedidoPanacheRepository implements PedidoRepository {

	@Inject
	PanachePedidoMapper panachePedidoMapper;

	@Override
	public Pedido save(Pedido pedido) {
		PanachePedido panachePedido = panachePedidoMapper.from(pedido);
		PanacheCliente panacheCliente = PanacheCliente.findById(panachePedido.getCliente().getId());
		PanacheCarrinho panacheCarrinho = PanacheCarrinho.findById(panachePedido.getCarrinho().getId());
		PanacheEnderecoEntrega panacheEnderecoEntrega = PanacheEnderecoEntrega
			.findById(panachePedido.getEndereco().getId());
		List<PanacheCartaoCredito> panacheCartaoCreditos = new ArrayList<>();
		panachePedido.getCartoesCredito().forEach(cartao -> {
			panacheCartaoCreditos.add(PanacheCartaoCredito.findById(cartao.getId()));
		});
		PanacheSituacaoPedido panacheSituacaoPedidoAprovacaoPagamento = PanacheSituacaoPedido
			.find("nome", SituacaoDoPedido.APROVACAO_DE_PAGAMENTO.getSituacao())
			.firstResult();
		panachePedido.setCliente(panacheCliente);
		panachePedido.setCarrinho(panacheCarrinho);
		panachePedido.setEndereco(panacheEnderecoEntrega);
		panachePedido.setCartoesCredito(panacheCartaoCreditos);
		panachePedido.setSituacaoPedido(panacheSituacaoPedidoAprovacaoPagamento);
		panachePedido.persist();
		return panachePedidoMapper.from(panachePedido);
	}

	@Override
	public List<Pedido> findAllByClienteId(Long clienteId) {
		List<PanachePedido> panachePedido = PanachePedido.find("cliente.id", clienteId).list();
		return panachePedidoMapper.from(panachePedido);
	}

}
