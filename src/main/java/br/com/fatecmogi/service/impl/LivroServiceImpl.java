package br.com.fatecmogi.service.impl;

import br.com.fatecmogi.controller.dto.livro.EditarLivroCommand;
import br.com.fatecmogi.controller.dto.livro.LivroFiltroDTO;
import br.com.fatecmogi.controller.dto.paginacao.PaginacaoDTO;
import br.com.fatecmogi.controller.exceptionHandler.CommandValidator;
import br.com.fatecmogi.controller.mapper.LivroMapper;
import br.com.fatecmogi.model.entity.livro.Livro;
import br.com.fatecmogi.model.exception.livro.LivroNaoEncontradoException;
import br.com.fatecmogi.model.repository.LivroRepository;
import br.com.fatecmogi.service.LivroService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class LivroServiceImpl implements LivroService {

	@Inject
	LivroRepository livroRepository;

	@Inject
	LivroMapper livroMapper;

	@Inject
	CommandValidator commandValidator;

	@Override
	@Transactional
	public List<Livro> listarComFiltros(LivroFiltroDTO filtro, PaginacaoDTO paginacao) {
		return livroRepository.findAll(filtro, paginacao);
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
