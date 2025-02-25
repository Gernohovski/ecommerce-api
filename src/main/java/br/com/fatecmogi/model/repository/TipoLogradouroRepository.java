package br.com.fatecmogi.model.repository;

import br.com.fatecmogi.model.entity.endereco.TipoLogradouro;

import java.util.List;
import java.util.Optional;

public interface TipoLogradouroRepository {

    List<TipoLogradouro> findAll();

    Optional<TipoLogradouro> findById(Long id);

}
