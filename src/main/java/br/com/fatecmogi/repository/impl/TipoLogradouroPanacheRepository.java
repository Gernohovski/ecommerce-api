package br.com.fatecmogi.repository.impl;

import br.com.fatecmogi.model.entity.endereco.TipoLogradouro;
import br.com.fatecmogi.model.repository.TipoLogradouroRepository;
import br.com.fatecmogi.repository.mapper.PanacheTipoLogradouroMapper;
import br.com.fatecmogi.repository.table.PanacheTipoLogradouro;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class TipoLogradouroPanacheRepository implements TipoLogradouroRepository {

    @Inject
    PanacheTipoLogradouroMapper panacheTipoLogradouroMapper;

    @Override
    public List<TipoLogradouro> findAll() {
        List<PanacheTipoLogradouro> panacheTipoLogradouro = PanacheTipoLogradouro.findAll().list();
        return panacheTipoLogradouroMapper.from(panacheTipoLogradouro);
    }

    @Override
    public Optional<TipoLogradouro> findById(Long id) {
        PanacheTipoLogradouro panacheTipoLogradouro = PanacheTipoLogradouro.findById(id);
        if (panacheTipoLogradouro == null) {
            return Optional.empty();
        }
        return Optional.of(panacheTipoLogradouroMapper.from(panacheTipoLogradouro));
    }

}
