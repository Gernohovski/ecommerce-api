package br.com.fatecmogi.service.impl;

import br.com.fatecmogi.model.entity.endereco.TipoResidencia;
import br.com.fatecmogi.model.repository.TipoResidenciaRepository;
import br.com.fatecmogi.service.TiposResidenciaService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class TiposResidenciaServiceImpl implements TiposResidenciaService {

	@Inject
	TipoResidenciaRepository tipoResidenciaRepository;

	@Override
	public List<TipoResidencia> findAll() {
		return tipoResidenciaRepository.findAll();
	}

}
