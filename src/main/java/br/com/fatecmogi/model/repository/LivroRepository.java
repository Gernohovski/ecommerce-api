package br.com.fatecmogi.model.repository;

import br.com.fatecmogi.controller.dto.livro.LivroFiltroDTO;
import br.com.fatecmogi.controller.dto.paginacao.PaginacaoDTO;
import br.com.fatecmogi.model.entity.livro.Livro;

import java.util.List;

public interface LivroRepository {

	List<Livro> findAll(LivroFiltroDTO filtro, PaginacaoDTO paginacao);

}
