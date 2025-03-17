package br.com.fatecmogi.model.repository;

import br.com.fatecmogi.model.entity.cliente.Genero;

import java.util.List;
import java.util.Optional;

public interface GeneroRepository {

	List<Genero> findAll();

	Optional<Genero> findById(Long id);

}
