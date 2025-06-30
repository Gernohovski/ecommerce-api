package br.com.fatecmogi.service.impl;

import br.com.fatecmogi.controller.dto.paginacao.PaginacaoDTO;
import br.com.fatecmogi.controller.dto.pedido.AdicionarPedidoCommand;
import br.com.fatecmogi.controller.dto.pedido.PedidoFiltroDTO;
import br.com.fatecmogi.controller.dto.pedido.SolicitarDevolucaoPedidoCommand;
import br.com.fatecmogi.controller.dto.pedido.SolicitarTrocaPedidoCommand;
import br.com.fatecmogi.controller.mapper.PedidoMapper;
import br.com.fatecmogi.controller.mapper.SolicitacaoDevolucaoMapper;
import br.com.fatecmogi.controller.mapper.SolicitacaoTrocaMapper;
import br.com.fatecmogi.controller.response.CustomPage;
import br.com.fatecmogi.model.entity.cupom.CupomTroca;
import br.com.fatecmogi.model.entity.pedido.Carrinho;
import br.com.fatecmogi.model.entity.pedido.Pedido;
import br.com.fatecmogi.model.entity.pedido.SituacaoPedido;
import br.com.fatecmogi.model.enums.AcoesSituacaoPedido;
import br.com.fatecmogi.model.enums.SituacaoDoPedido;
import br.com.fatecmogi.model.exception.itemCarrinho.CarrinhoNaoEncontradoException;
import br.com.fatecmogi.model.exception.itemCarrinho.ItemCarrinhoNaoEncontradoException;
import br.com.fatecmogi.model.exception.livro.LivroNaoEncontradoException;
import br.com.fatecmogi.model.exception.pedido.NaoPossivelReenviarPedidoException;
import br.com.fatecmogi.model.exception.pedido.PedidoNaoEncontradoException;
import br.com.fatecmogi.model.exception.situacaoPedido.AcaoNaoEncontradaException;
import br.com.fatecmogi.model.exception.solicitacaoTroca.SolicitacaoTrocaNaoEcontradaException;
import br.com.fatecmogi.model.repository.*;
import br.com.fatecmogi.service.CupomService;
import br.com.fatecmogi.service.EstoqueService;
import br.com.fatecmogi.service.PedidoService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Objects;

@ApplicationScoped
public class PedidoServiceImpl implements PedidoService {

	@Inject
	PedidoRepository pedidoRepository;

	@Inject
	CarrinhoRepository carrinhoRepository;

	@Inject
	LivroRepository livroRepository;

	@Inject
	SituacaoPedidoRepository situacaoPedidoRepository;

	@Inject
	PedidoMapper pedidoMapper;

	@Inject
	EstoqueService estoqueService;

	@Inject
	SolicitacaoTrocaRepository solicitacaoTrocaRepository;

	@Inject
	SolicitacaoDevolucaoRepository solicitacaoDevolucaoRepository;

	@Inject
	CupomService cupomService;

	@Inject
	SolicitacaoTrocaMapper solicitacaoTrocaMapper;

	@Inject
	SolicitacaoDevolucaoMapper solicitacaoDevolucaoMapper;

	@Override
	@Transactional
	public Pedido cadastrarPedido(AdicionarPedidoCommand command) {
		var pedido = pedidoMapper.from(command);
		var carrinho = carrinhoRepository.buscar(command.getCarrinhoId())
			.orElseThrow(CarrinhoNaoEncontradoException::new);
		carrinho.setComprado(true);
		carrinhoRepository.atualizar(carrinho);
		this.darBaixa(carrinho);
		cupomService.marcarComoUtilzados(command.getCuponsTroca());
		return pedidoRepository.save(pedido);
	}

	@Override
	@Transactional
	public List<Pedido> listarPedidosCliente(Long clienteId) {
		return pedidoRepository.findAllByClienteId(clienteId);
	}

	@Override
	public Pedido buscar(Long id) {
		return pedidoRepository.findById(id).orElseThrow(PedidoNaoEncontradoException::new);
	}

	@Override
	public CustomPage<Pedido> listarComFiltros(PedidoFiltroDTO filtro, PaginacaoDTO paginacao) {
		return pedidoRepository.findAll(filtro, paginacao);
	}

	@Override
	@Transactional
	public Pedido cancelar(Long id) {
		return pedidoRepository.updateSituation(id, SituacaoDoPedido.PEDIDO_CANCELADO);
	}

	@Override
	@Transactional
	public Pedido alterarSituacao(Long id, String acao) {
		var pedido = pedidoRepository.findById(id).orElseThrow(PedidoNaoEncontradoException::new);
		if (acao.equals("Realizar novo envio")) {
			validarDisponibilidadeEmEstoque(id);
		}
		var acaoSituacaoPedido = AcoesSituacaoPedido.getAcaoPedido(acao);
		if (acaoSituacaoPedido == null) {
			throw new AcaoNaoEncontradaException();
		}
		if (acao.equals("Adicionar ao estoque")) {
			if (pedido.getSituacaoPedido().getNome().equals(SituacaoDoPedido.TROCA_RECEBIDA.getSituacao())) {
				darEntradaProdutoTroca(id);
				acaoSituacaoPedido = AcoesSituacaoPedido.ADICIONAR_AO_ESTOQUE;
			}
			if (pedido.getSituacaoPedido().getNome().equals(SituacaoDoPedido.DEVOLUCAO_RECEBIDA.getSituacao())) {
				darEntradaProdutoDevolucao(id);
				acaoSituacaoPedido = AcoesSituacaoPedido.ADICIONAR_DEVOLUCAO_AO_ESTOQUE;
			}
		}
		if (acao.equals("Descartar")) {
			if (pedido.getSituacaoPedido().getNome().equals(SituacaoDoPedido.TROCA_RECEBIDA.getSituacao())) {
				acaoSituacaoPedido = AcoesSituacaoPedido.DESCARTAR;
			}
			if (pedido.getSituacaoPedido().getNome().equals(SituacaoDoPedido.DEVOLUCAO_RECEBIDA.getSituacao())) {
				acaoSituacaoPedido = AcoesSituacaoPedido.DESCARTAR_DEVOLUCAO;
			}
		}
		return pedidoRepository.updateSituation(id, acaoSituacaoPedido.getSituacaoDoPedido());
	}

	@Override
	@Transactional
	public Pedido solicitarTroca(SolicitarTrocaPedidoCommand command) {
		var pedido = pedidoRepository.findById(command.getPedidoId()).orElseThrow(PedidoNaoEncontradoException::new);
		var solicitacaoTroca = solicitacaoTrocaMapper.from(command);
		solicitacaoTroca.setPedido(pedido);
		solicitacaoTrocaRepository.save(solicitacaoTroca);
		return this.alterarSituacao(command.getPedidoId(), AcoesSituacaoPedido.SOLICITAR_TROCA.getAcao());
	}

	@Override
	@Transactional
	public Pedido solicitarDevolucao(SolicitarDevolucaoPedidoCommand command) {
		var pedido = pedidoRepository.findById(command.getPedidoId()).orElseThrow(PedidoNaoEncontradoException::new);
		var solicitarDevolucao = solicitacaoDevolucaoMapper.from(command);
		solicitarDevolucao.setPedido(pedido);
		solicitacaoDevolucaoRepository.save(solicitarDevolucao);
		return this.alterarSituacao(command.getPedidoId(), AcoesSituacaoPedido.SOLICITAR_DEVOLUCAO.getAcao());
	}

	@Override
	@Transactional
	public CupomTroca aprovarTroca(Long id) {
		var solicitacaoTroca = solicitacaoTrocaRepository.findByPedidoId(id)
			.orElseThrow(SolicitacaoTrocaNaoEcontradaException::new);
		var cupom = cupomService.gerarCupomTroca(solicitacaoTroca);
		alterarSituacao(id, "Aprovar troca");
		return cupom;
	}

	@Override
	public List<SituacaoPedido> listarSituacoesPedido() {
		return situacaoPedidoRepository.listarTodas();
	}

	private void validarDisponibilidadeEmEstoque(Long id) {
		var pedido = pedidoRepository.findById(id).orElseThrow(PedidoNaoEncontradoException::new);
		var itensCarrinho = pedido.getCarrinho().getItens();
		var livrosId = itensCarrinho.stream().map(item -> item.getLivro().getId()).toList();
		livrosId.forEach(livroId -> {
			var itemCarrinho = itensCarrinho.stream()
				.filter(item -> Objects.equals(item.getLivro().getId(), livroId))
				.findFirst()
				.orElseThrow(ItemCarrinhoNaoEncontradoException::new);
			var livro = livroRepository.findById(livroId).orElseThrow(LivroNaoEncontradoException::new);
			if (livro.getQuantidade() <= itemCarrinho.getQuantidade()) {
				throw new NaoPossivelReenviarPedidoException();
			}
		});
	}

	private void darBaixa(Carrinho carrinho) {
		var itensEstoque = carrinho.getItens()
			.stream()
			.map(item -> estoqueService.obterPorLivroId(item.getLivro().getId()))
			.toList();
		itensEstoque.forEach(itemEstoque -> {
			var itemCorrespondente = carrinho.getItens()
				.stream()
				.filter(item -> item.getLivro().getId().equals(itemEstoque.getLivro().getId()))
				.findFirst();
			itemCorrespondente.ifPresent(item -> {
				itemEstoque.setQuantidade(itemEstoque.getQuantidade() - item.getQuantidade());
				estoqueService.darBaixa(itemEstoque);
			});
		});
	}

	private void darEntradaProdutoTroca(Long pedidoId) {
		var solicitacaoTroca = solicitacaoTrocaRepository.findByPedidoId(pedidoId)
			.orElseThrow(SolicitacaoTrocaNaoEcontradaException::new);
		var itensEstoque = solicitacaoTroca.getItem()
			.stream()
			.map(item -> estoqueService.obterPorLivroId(item.getItemPedido().getLivro().getId()))
			.toList();
		itensEstoque.forEach(itemEstoque -> {
			var itemCorrespondente = solicitacaoTroca.getItem()
				.stream()
				.filter(item -> item.getItemPedido().getLivro().getId().equals(itemEstoque.getLivro().getId()))
				.findFirst();
			itemCorrespondente.ifPresent(item -> {
				itemEstoque.setQuantidade(itemEstoque.getQuantidade() + item.getItemPedido().getQuantidade());
				estoqueService.darEntrada(itemEstoque);
			});
		});
	}

	private void darEntradaProdutoDevolucao(Long pedidoId) {
		var solicitacaoDevolucao = solicitacaoDevolucaoRepository.findByPedidoId(pedidoId)
			.orElseThrow(SolicitacaoTrocaNaoEcontradaException::new);
		var itensEstoque = solicitacaoDevolucao.getItem()
			.stream()
			.map(item -> estoqueService.obterPorLivroId(item.getItemPedido().getLivro().getId()))
			.toList();
		itensEstoque.forEach(itemEstoque -> {
			var itemCorrespondente = solicitacaoDevolucao.getItem()
				.stream()
				.filter(item -> item.getItemPedido().getLivro().getId().equals(itemEstoque.getLivro().getId()))
				.findFirst();
			itemCorrespondente.ifPresent(item -> {
				itemEstoque.setQuantidade(itemEstoque.getQuantidade() + item.getQuantidade());
				estoqueService.darEntrada(itemEstoque);
			});
		});
	}

}
