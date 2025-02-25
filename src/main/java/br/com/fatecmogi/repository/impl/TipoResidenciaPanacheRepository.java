package br.com.fatecmogi.repository.impl;

import br.com.fatecmogi.model.entity.endereco.TipoResidencia;
import br.com.fatecmogi.model.repository.TipoResidenciaRepository;
import br.com.fatecmogi.repository.mapper.PanacheTipoResidenciaMapper;
import br.com.fatecmogi.repository.table.PanacheTipoResidencia;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class TipoResidenciaPanacheRepository implements TipoResidenciaRepository {

    @Inject
    PanacheTipoResidenciaMapper panacheTipoResidenciaMapper;

    @Override
    public List<TipoResidencia> findAll() {
        List<PanacheTipoResidencia> panacheTipoResidencia = PanacheTipoResidencia.findAll().list();
        return panacheTipoResidenciaMapper.from(panacheTipoResidencia);
    }

    @Override
    public Optional<TipoResidencia> findById(Long id) {
        PanacheTipoResidencia panacheTipoResidencia = PanacheTipoResidencia.findById(id);
        if (panacheTipoResidencia == null) {
            return Optional.empty();
        }
        return Optional.of(panacheTipoResidenciaMapper.from(panacheTipoResidencia));
    }
}
