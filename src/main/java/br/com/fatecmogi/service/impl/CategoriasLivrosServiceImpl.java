package br.com.fatecmogi.service.impl;

import br.com.fatecmogi.controller.dto.livro.CategoriaLivroDTO;
import br.com.fatecmogi.model.repository.CategoriasLivrosRepository;
import br.com.fatecmogi.service.CategoriasLivrosService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class CategoriasLivrosServiceImpl implements CategoriasLivrosService {

	@Inject
	CategoriasLivrosRepository categoriasLivrosRepository;

	@Override
	public List<CategoriaLivroDTO> listar() {
		return categoriasLivrosRepository.findAll();
	}

}
