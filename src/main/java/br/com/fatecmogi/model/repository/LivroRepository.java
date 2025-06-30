package br.com.fatecmogi.model.repository;

import br.com.fatecmogi.controller.dto.livro.LivroFiltroDTO;
import br.com.fatecmogi.controller.dto.paginacao.PaginacaoDTO;
import br.com.fatecmogi.controller.response.CustomPage;
import br.com.fatecmogi.model.entity.livro.Livro;

import java.util.List;
import java.util.Optional;

public interface LivroRepository {

	CustomPage<Livro> findAll(LivroFiltroDTO filtro, PaginacaoDTO paginacao);

	Livro update(Livro livro);

	Optional<Livro> findById(Long id);

	List<Livro> findAll();

}
