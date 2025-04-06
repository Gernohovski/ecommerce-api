package br.com.fatecmogi.model.repository;

import br.com.fatecmogi.model.entity.cupom.CupomPromocional;

import java.util.Optional;

public interface CupomPromocionalRepository {

	CupomPromocional save(CupomPromocional cupomPromocional);

	Optional<CupomPromocional> findByCodigo(String codigo);

	boolean existsByCodigo(String codigo);

}
