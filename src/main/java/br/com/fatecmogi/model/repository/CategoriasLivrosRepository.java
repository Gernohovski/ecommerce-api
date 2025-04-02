package br.com.fatecmogi.model.repository;

import br.com.fatecmogi.controller.dto.livro.CategoriaLivroDTO;
import br.com.fatecmogi.model.entity.livro.Categoria;

import java.util.List;

public interface CategoriasLivrosRepository {

    List<CategoriaLivroDTO> findAll();

}
