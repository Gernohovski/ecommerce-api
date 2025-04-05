package br.com.fatecmogi.model.repository;

import br.com.fatecmogi.controller.dto.livro.CategoriaLivroDTO;

import java.util.List;

public interface CategoriasLivrosRepository {

	List<CategoriaLivroDTO> findAll();

}
