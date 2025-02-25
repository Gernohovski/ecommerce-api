package br.com.fatecmogi.service.impl;

import br.com.fatecmogi.model.entity.endereco.TipoLogradouro;
import br.com.fatecmogi.model.repository.TipoLogradouroRepository;
import br.com.fatecmogi.service.TiposLogradouroService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class TiposLogradouroServiceImpl implements TiposLogradouroService {

    @Inject
    TipoLogradouroRepository tipoLogradouroRepository;

    @Override
    public List<TipoLogradouro> findAll() {
        return tipoLogradouroRepository.findAll();
    }
}
