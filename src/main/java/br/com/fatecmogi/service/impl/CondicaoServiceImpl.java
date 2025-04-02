package br.com.fatecmogi.service.impl;

import br.com.fatecmogi.model.entity.livro.Condicao;
import br.com.fatecmogi.model.repository.CondicaoRepository;
import br.com.fatecmogi.service.CondicaoService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class CondicaoServiceImpl implements CondicaoService {

    @Inject
    CondicaoRepository condicaoRepository;

    @Override
    public List<Condicao> listar() {
        return condicaoRepository.findAll();
    }

}
