package br.com.fatecmogi.service;

import br.com.fatecmogi.controller.dto.livro.EditarLivroCommand;
import br.com.fatecmogi.controller.dto.livro.LivroFiltroDTO;
import br.com.fatecmogi.controller.dto.paginacao.PaginacaoDTO;
import br.com.fatecmogi.model.entity.livro.Livro;

import java.util.List;

public interface LivroService {

	List<Livro> listarComFiltros(LivroFiltroDTO filtro, PaginacaoDTO paginacao);

	Livro atualizar(Long id, EditarLivroCommand command);

}
