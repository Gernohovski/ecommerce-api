package br.com.fatecmogi.model.repository;

import br.com.fatecmogi.model.entity.livro.Autor;

import java.util.List;

public interface AutorRepository {

	List<Autor> findAll();

}
