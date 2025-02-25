package br.com.fatecmogi.repository.impl;

import br.com.fatecmogi.model.entity.cliente.TipoTelefone;
import br.com.fatecmogi.model.repository.TipoTelefoneRepository;
import br.com.fatecmogi.repository.mapper.PanacheTipoTelefoneMapper;
import br.com.fatecmogi.repository.table.PanacheTipoTelefone;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class TipoTelefonePanacheRepository implements TipoTelefoneRepository {

    @Inject
    PanacheTipoTelefoneMapper panacheTipoTelefoneMapper;

    @Override
    public List<TipoTelefone> findAll() {
        List<PanacheTipoTelefone> panacheTipoTelefone = PanacheTipoTelefone.findAll().list();
        return panacheTipoTelefoneMapper.from(panacheTipoTelefone);
    }

    @Override
    public Optional<TipoTelefone> findById(Long id) {
        PanacheTipoTelefone panacheTipoTelefone = PanacheTipoTelefone.findById(id);
        if (panacheTipoTelefone == null) {
            return Optional.empty();
        }
        return Optional.of(panacheTipoTelefoneMapper.from(panacheTipoTelefone));
    }

}
