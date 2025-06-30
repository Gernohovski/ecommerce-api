package br.com.fatecmogi.repository.impl;

import br.com.fatecmogi.controller.dto.paginacao.PaginacaoDTO;
import br.com.fatecmogi.controller.dto.pedido.PedidoFiltroDTO;
import br.com.fatecmogi.controller.dto.vendas.VendasPorCategoriaDTO;
import br.com.fatecmogi.controller.response.CustomPage;
import br.com.fatecmogi.model.entity.pedido.Pedido;
import br.com.fatecmogi.model.enums.SituacaoDoPedido;
import br.com.fatecmogi.model.repository.PedidoRepository;
import br.com.fatecmogi.repository.mapper.PanachePedidoMapper;
import br.com.fatecmogi.repository.table.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static io.quarkus.hibernate.orm.panache.PanacheEntityBase.getEntityManager;

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

		if (filtro.clienteId != null) {
			total = PanachePedido.find("cliente.id", filtro.clienteId).count();
		}
		else {
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
		panachePedido.setDataAlteracao(LocalDateTime.now());
		EntityManager entityManager = PanachePedido.getEntityManager();
		entityManager.merge(panachePedido);
		return panachePedidoMapper.from(panachePedido);
	}

	@Override
	public List<VendasPorCategoriaDTO> buscarVendasPorPeriodo(LocalDate inicio, LocalDate fim,
			List<String> categoriaIds) {

		StringBuilder jpql = new StringBuilder("""
				    SELECT
				        FUNCTION('TO_CHAR', p.dataPedido, 'YYYY-MM'),
				        c.id,
				        c.nome,
				        SUM(ip.quantidade)
				    FROM PanachePedido   p
				    JOIN p.itensPedido   ip
				    JOIN ip.livro        l
				    JOIN l.categorias    c
				    WHERE p.dataPedido BETWEEN :inicio AND :fim
				""");

		if (categoriaIds != null && !categoriaIds.isEmpty()) {
			jpql.append(" AND c.id IN :catIds");
		}

		jpql.append("""
				    GROUP BY FUNCTION('TO_CHAR', p.dataPedido, 'YYYY-MM'), c.id, c.nome
				    ORDER BY FUNCTION('TO_CHAR', p.dataPedido, 'YYYY-MM'), c.nome
				""");

		EntityManager em = PanachePedido.getEntityManager();
		var query = em.createQuery(jpql.toString());

		query.setParameter("inicio", inicio);
		query.setParameter("fim", fim);

		if (categoriaIds != null && !categoriaIds.isEmpty()) {
			List<Long> catIdsLong = categoriaIds.stream().map(Long::valueOf).toList();
			query.setParameter("catIds", catIdsLong);
		}

		List<Object[]> resultados = query.getResultList();

		return resultados.stream()
			.map(obj -> new VendasPorCategoriaDTO((String) obj[0], (Long) obj[1], (String) obj[2], (Long) obj[3]))
			.toList();
	}

}
