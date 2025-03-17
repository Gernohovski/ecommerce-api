package br.com.fatecmogi.service.impl;

import br.com.fatecmogi.model.entity.cliente.TipoTelefone;
import br.com.fatecmogi.model.repository.TipoTelefoneRepository;
import br.com.fatecmogi.service.TiposTelefoneService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class TiposTelefoneServiceImpl implements TiposTelefoneService {

	@Inject
	TipoTelefoneRepository tipoTelefoneRepository;

	@Override
	public List<TipoTelefone> findAll() {
		return tipoTelefoneRepository.findAll();
	}

}
