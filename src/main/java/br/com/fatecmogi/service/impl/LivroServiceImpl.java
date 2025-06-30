package br.com.fatecmogi.service.impl;

import br.com.fatecmogi.controller.dto.livro.EditarLivroCommand;
import br.com.fatecmogi.controller.dto.livro.LivroFiltroDTO;
import br.com.fatecmogi.controller.dto.paginacao.PaginacaoDTO;
import br.com.fatecmogi.controller.exceptionHandler.CommandValidator;
import br.com.fatecmogi.controller.mapper.LivroMapper;
import br.com.fatecmogi.controller.response.CustomPage;
import br.com.fatecmogi.model.entity.livro.Livro;
import br.com.fatecmogi.model.entity.pedido.Carrinho;
import br.com.fatecmogi.model.entity.pedido.ItemCarrinho;
import br.com.fatecmogi.model.exception.livro.LivroNaoEncontradoException;
import br.com.fatecmogi.model.repository.CarrinhoRepository;
import br.com.fatecmogi.model.repository.LivroRepository;
import br.com.fatecmogi.service.LivroService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class LivroServiceImpl implements LivroService {

	@Inject
	LivroRepository livroRepository;

	@Inject
	CarrinhoRepository carrinhoRepository;

	@Inject
	LivroMapper livroMapper;

	@Inject
	CommandValidator commandValidator;

	@Override
	@Transactional
	public CustomPage<Livro> listarComFiltros(LivroFiltroDTO filtro, PaginacaoDTO paginacao) {
		var carrinhosValidos = carrinhoRepository.getValid();
		var livros = livroRepository.findAll(filtro, paginacao);
		Map<Long, Integer> quantidadeReservadaPorLivro = new HashMap<>();
		for (Carrinho carrinho : carrinhosValidos) {
			for (ItemCarrinho item : carrinho.getItens()) {
				var livro = item.getLivro();
				if (livro != null) {
					quantidadeReservadaPorLivro.merge(livro.getId(), item.getQuantidade(), Integer::sum);
				}
			}
		}
		for (Livro livro : livros.getContent()) {
			int reservado = quantidadeReservadaPorLivro.getOrDefault(livro.getId(), 0);
			int novaQuantidade = Math.max(0, livro.getQuantidade() - reservado);
			livro.setQuantidade(novaQuantidade);
		}
		return livros;
	}

	@Override
	public List<Livro> buscarTodos() {
		var livros = livroRepository.findAll();
		return livros.stream().filter(livro -> livro.getQuantidade() > 0).toList();
	}

	@Override
	@Transactional
	public Livro atualizar(Long id, EditarLivroCommand command) {
		commandValidator.validate(command);
		var livro = livroRepository.findById(id).orElseThrow(LivroNaoEncontradoException::new);
		var livroAtualizado = livroMapper.update(livro, command);
		livro.validarValorVenda();
		return livroRepository.update(livroAtualizado);
	}

	@Override
	public Livro buscar(Long id) {
		return livroRepository.findById(id).orElseThrow(LivroNaoEncontradoException::new);
	}

}
