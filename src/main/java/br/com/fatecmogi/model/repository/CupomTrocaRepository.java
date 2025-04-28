package br.com.fatecmogi.model.repository;

import br.com.fatecmogi.model.entity.cupom.CupomTroca;

import java.util.List;

public interface CupomTrocaRepository {

	CupomTroca save(CupomTroca cupomTroca);

	List<CupomTroca> findAllByClienteId(Long id);

	CupomTroca update(CupomTroca cupomTroca);

}
