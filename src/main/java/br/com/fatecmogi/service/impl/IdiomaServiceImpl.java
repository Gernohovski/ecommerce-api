package br.com.fatecmogi.service.impl;

import br.com.fatecmogi.model.entity.livro.Idioma;
import br.com.fatecmogi.model.repository.IdiomaRepository;
import br.com.fatecmogi.service.IdiomaService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class IdiomaServiceImpl implements IdiomaService {

	@Inject
	IdiomaRepository idiomaRepository;

	@Override
	public List<Idioma> listar() {
		return idiomaRepository.findAll();
	}

}
