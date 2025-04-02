package br.com.fatecmogi.service;

import br.com.fatecmogi.controller.dto.livro.CategoriaLivroDTO;
import br.com.fatecmogi.model.entity.livro.Categoria;

import java.util.List;

public interface CategoriasLivrosService {

    List<CategoriaLivroDTO> listar();

}
