package br.com.fatecmogi.service.impl;

import br.com.fatecmogi.model.entity.livro.Autor;
import br.com.fatecmogi.model.repository.AutorRepository;
import br.com.fatecmogi.service.AutorService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class AutorServiceImpl implements AutorService {

    @Inject
    AutorRepository autorRepository;


    @Override
    public List<Autor> listar() {
        return autorRepository.findAll();
    }
}
