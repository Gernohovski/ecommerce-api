package br.com.fatecmogi.repository.impl;

import br.com.fatecmogi.model.entity.livro.Idioma;
import br.com.fatecmogi.model.repository.IdiomaRepository;
import br.com.fatecmogi.repository.mapper.PanacheIdiomaMapper;
import br.com.fatecmogi.repository.table.PanacheIdioma;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class IdiomaPanacheRepository implements IdiomaRepository {

	@Inject
	PanacheIdiomaMapper panacheIdiomaMapper;

	@Override
	public List<Idioma> findAll() {
		List<PanacheIdioma> panacheIdioma = PanacheIdioma.findAll().list();
		return panacheIdiomaMapper.from(panacheIdioma);
	}

}
