package br.com.fatecmogi.repository.impl;

import br.com.fatecmogi.model.entity.cupom.CupomTroca;
import br.com.fatecmogi.model.repository.CupomTrocaRepository;
import br.com.fatecmogi.repository.mapper.PanacheCupomTrocaMapper;
import br.com.fatecmogi.repository.table.PanacheCupomTroca;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@ApplicationScoped
public class CupomTrocaPanacheRepository implements CupomTrocaRepository {

	@Inject
	PanacheCupomTrocaMapper panacheCupomTrocaMapper;

	@Override
	public CupomTroca save(CupomTroca cupomTroca) {
		PanacheCupomTroca panacheCupomTroca = panacheCupomTrocaMapper.from(cupomTroca);
		panacheCupomTroca.persist();
		return panacheCupomTrocaMapper.from(panacheCupomTroca);
	}

	@Override
	public List<CupomTroca> findAllByClienteId(Long id) {
		List<PanacheCupomTroca> panacheCupomTroca = PanacheCupomTroca.
				find("cliente.id = ?1 and utilizado = false", id).list();
		return panacheCupomTrocaMapper.from(panacheCupomTroca);
	}

	@Override
	public CupomTroca update(CupomTroca cupomTroca) {
		PanacheCupomTroca panacheCupomTroca = PanacheCupomTroca.findById(cupomTroca.getId());
		panacheCupomTroca = panacheCupomTrocaMapper.update(panacheCupomTroca, cupomTroca);
		EntityManager entityManager = PanacheCupomTroca.getEntityManager();
		entityManager.merge(panacheCupomTroca);
		return null;
	}

}
