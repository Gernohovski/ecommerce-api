package br.com.fatecmogi.model.repository;

import br.com.fatecmogi.model.entity.cliente.TipoTelefone;

import java.util.List;
import java.util.Optional;

public interface TipoTelefoneRepository {

	List<TipoTelefone> findAll();

	Optional<TipoTelefone> findById(Long id);

}
