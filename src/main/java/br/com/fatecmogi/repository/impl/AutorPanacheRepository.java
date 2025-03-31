package br.com.fatecmogi.repository.impl;

import br.com.fatecmogi.model.entity.livro.Autor;
import br.com.fatecmogi.model.repository.AutorRepository;
import br.com.fatecmogi.repository.mapper.PanacheAutorMapper;
import br.com.fatecmogi.repository.mapper.PanacheLivroMapper;
import br.com.fatecmogi.repository.table.PanacheAutor;
import br.com.fatecmogi.repository.table.PanacheLivro;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class AutorPanacheRepository implements AutorRepository {

    @Inject
    PanacheAutorMapper panacheAutorMapper;

    @Override
    public List<Autor> findAll() {
        List<PanacheAutor> panacheAutores = PanacheAutor.findAll().list();
        return panacheAutorMapper.from(panacheAutores);
    }

}
