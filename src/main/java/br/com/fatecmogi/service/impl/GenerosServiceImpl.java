package br.com.fatecmogi.service.impl;

import br.com.fatecmogi.model.entity.cliente.Genero;
import br.com.fatecmogi.model.repository.GeneroRepository;
import br.com.fatecmogi.service.GenerosService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class GenerosServiceImpl implements GenerosService {

    @Inject
    GeneroRepository generoRepository;

    @Override
    public List<Genero> findAll() {
        return generoRepository.findAll();
    }
}
