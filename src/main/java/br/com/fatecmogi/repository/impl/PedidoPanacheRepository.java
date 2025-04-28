package br.com.fatecmogi.repository.impl;

import br.com.fatecmogi.controller.dto.paginacao.PaginacaoDTO;
import br.com.fatecmogi.controller.dto.pedido.PedidoFiltroDTO;
import br.com.fatecmogi.controller.response.CustomPage;
import br.com.fatecmogi.model.entity.pedido.Pedido;
import br.com.fatecmogi.model.enums.SituacaoDoPedido;
import br.com.fatecmogi.model.repository.PedidoRepository;
import br.com.fatecmogi.repository.mapper.PanachePedidoMapper;
import br.com.fatecmogi.repository.table.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.*;
import java.util.stream.Collectors;

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
		panachePedido.persistDependecies();
		return panachePedidoMapper.from(panachePedido);
	}

	@Override
	public List<Pedido> findAllByClienteId(Long clienteId) {
		List<PanachePedido> panachePedido = PanachePedido.find("cliente.id", clienteId).list();
		return panachePedidoMapper.from(panachePedido);
	}

	@Override
	public CustomPage<Pedido> findAll(PedidoFiltroDTO filtro, PaginacaoDTO paginacao) {
		StringBuilder query = new StringBuilder("SELECT p FROM PanachePedido p JOIN p.situacaoPedido s WHERE 1=1");
		Map<String, Object> params = new HashMap<>();
		if (filtro.situacoesId != null && !filtro.situacoesId.isEmpty()) {
			query.append(" AND situacaoPedido.id IN ("
					+ filtro.situacoesId.stream().map(String::valueOf).collect(Collectors.joining(",")) + ")");
		}
		if (filtro.clienteId != null) {
			query.append(" AND cliente.id = :clienteId");
			params.put("clienteId", filtro.clienteId);
		}
		String orderBy = " ORDER BY " + filtro.sortBy + " "
				+ (filtro.sortDirection.equalsIgnoreCase("DESC") ? "DESC" : "ASC");

		Long total;

		if(filtro.clienteId != null) {
			total = PanachePedido.find("cliente.id", filtro.clienteId).count();
		} else {
			total = PanachePedido.findAll().count();
		}

		var pedidos = panachePedidoMapper
			.from(PanachePedido.find(query + orderBy, params).page(paginacao.getPage(), paginacao.getSize()).list());

		return CustomPage.<Pedido>builder().content(pedidos).count(total.intValue()).build();
	}

	@Override
	public Optional<Pedido> findById(Long id) {
		PanachePedido panachePedido = PanachePedido.findById(id);

		if (panachePedido == null) {
			return Optional.empty();
		}

		return Optional.of(panachePedidoMapper.from(panachePedido));
	}

	@Override
	public Pedido updateSituation(Long id, SituacaoDoPedido situacaoDoPedido) {
		PanachePedido panachePedido = PanachePedido.findById(id);
		PanacheSituacaoPedido panacheSituacaoPedido = PanacheSituacaoPedido.find("nome", situacaoDoPedido.getSituacao())
			.firstResult();
		panachePedido.setSituacaoPedido(panacheSituacaoPedido);
		EntityManager entityManager = PanachePedido.getEntityManager();
		entityManager.merge(panachePedido);
		return panachePedidoMapper.from(panachePedido);
	}

}
