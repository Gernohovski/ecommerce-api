package br.com.fatecmogi.model.repository;

import br.com.fatecmogi.model.entity.livro.Condicao;

import java.util.List;

public interface CondicaoRepository {

    List<Condicao> findAll();

}
