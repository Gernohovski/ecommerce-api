package br.com.fatecmogi.model.repository;

import br.com.fatecmogi.model.entity.endereco.TipoResidencia;

import java.util.List;
import java.util.Optional;

public interface TipoResidenciaRepository {

	List<TipoResidencia> findAll();

	Optional<TipoResidencia> findById(Long id);

}
