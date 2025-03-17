package br.com.fatecmogi.repository.impl;

import br.com.fatecmogi.model.entity.cliente.Genero;
import br.com.fatecmogi.model.repository.GeneroRepository;
import br.com.fatecmogi.repository.mapper.PanacheGeneroMapper;
import br.com.fatecmogi.repository.table.PanacheGenero;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class GeneroPanacheRepository implements GeneroRepository {

	@Inject
	PanacheGeneroMapper panacheGeneroMapper;

	@Override
	public List<Genero> findAll() {
		List<PanacheGenero> panacheGenero = PanacheGenero.findAll().list();
		return panacheGeneroMapper.from(panacheGenero);
	}

	@Override
	public Optional<Genero> findById(Long id) {
		PanacheGenero panacheGenero = PanacheGenero.findById(id);
		if (panacheGenero == null) {
			return Optional.empty();
		}
		return Optional.of(panacheGeneroMapper.from(panacheGenero));
	}

}
