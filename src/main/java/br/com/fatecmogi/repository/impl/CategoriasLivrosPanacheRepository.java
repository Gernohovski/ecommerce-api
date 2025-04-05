package br.com.fatecmogi.repository.impl;

import br.com.fatecmogi.controller.dto.livro.CategoriaLivroDTO;
import br.com.fatecmogi.model.repository.CategoriasLivrosRepository;
import br.com.fatecmogi.repository.mapper.PanacheCategoriasLivrosMapper;
import br.com.fatecmogi.repository.table.PanacheCategoria;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class CategoriasLivrosPanacheRepository implements CategoriasLivrosRepository {

	@Inject
	PanacheCategoriasLivrosMapper panacheCategoriasLivrosMapper;

	@Override
	public List<CategoriaLivroDTO> findAll() {
		List<PanacheCategoria> panacheCategorias = PanacheCategoria.findAll().list();
		return panacheCategoriasLivrosMapper.from(panacheCategorias);
	}

}
