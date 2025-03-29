package br.com.fatecmogi.service.impl;

import br.com.fatecmogi.controller.dto.livro.LivroFiltroDTO;
import br.com.fatecmogi.controller.dto.paginacao.PaginacaoDTO;
import br.com.fatecmogi.model.entity.livro.Livro;
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

	@Override
	@Transactional
	public List<Livro> listarComFiltros(LivroFiltroDTO filtro, PaginacaoDTO paginacao) {
		return livroRepository.findAll(filtro, paginacao);
	}

}
