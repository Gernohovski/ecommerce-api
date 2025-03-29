package br.com.fatecmogi.service;

import br.com.fatecmogi.controller.dto.livro.LivroFiltroDTO;
import br.com.fatecmogi.controller.dto.paginacao.PaginacaoDTO;
import br.com.fatecmogi.model.entity.livro.Livro;

import java.util.List;

public interface LivroService {

	public List<Livro> listarComFiltros(LivroFiltroDTO filtro, PaginacaoDTO paginacao);

}
