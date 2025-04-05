package br.com.fatecmogi.model.repository;

import br.com.fatecmogi.model.entity.livro.Idioma;

import java.util.List;

public interface IdiomaRepository {

	List<Idioma> findAll();

}
