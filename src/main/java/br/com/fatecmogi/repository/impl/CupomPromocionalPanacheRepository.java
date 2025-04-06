package br.com.fatecmogi.repository.impl;

import br.com.fatecmogi.model.entity.cupom.CupomPromocional;
import br.com.fatecmogi.model.repository.CupomPromocionalRepository;
import br.com.fatecmogi.repository.mapper.PanacheCupomPromocionalMapper;
import br.com.fatecmogi.repository.table.PanacheCupomPromocional;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Optional;

@ApplicationScoped
public class CupomPromocionalPanacheRepository implements CupomPromocionalRepository {

	@Inject
	PanacheCupomPromocionalMapper cupomPromocionalMapper;

	@Override
	public CupomPromocional save(CupomPromocional cupomPromocional) {
		PanacheCupomPromocional panacheCupomPromocional = cupomPromocionalMapper.from(cupomPromocional);
		panacheCupomPromocional.persist();
		return cupomPromocionalMapper.from(panacheCupomPromocional);
	}

	@Override
	public Optional<CupomPromocional> findByCodigo(String codigo) {
		PanacheCupomPromocional panacheCupomPromocional = PanacheCupomPromocional.find("codigo", codigo).firstResult();
		if (panacheCupomPromocional == null) {
			return Optional.empty();
		}
		return Optional.of(cupomPromocionalMapper.from(panacheCupomPromocional));
	}

	@Override
	public boolean existsByCodigo(String codigo) {
		return PanacheCupomPromocional.find("codigo", codigo).count() > 0;
	}

}
