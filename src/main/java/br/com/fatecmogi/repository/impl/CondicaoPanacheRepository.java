package br.com.fatecmogi.repository.impl;

import br.com.fatecmogi.model.entity.livro.Condicao;
import br.com.fatecmogi.model.repository.CondicaoRepository;
import br.com.fatecmogi.repository.mapper.PanacheCondicaoMapper;
import br.com.fatecmogi.repository.table.PanacheCondicao;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class CondicaoPanacheRepository implements CondicaoRepository {

	@Inject
	PanacheCondicaoMapper panacheCondicaoMapper;

	@Override
	public List<Condicao> findAll() {
		List<PanacheCondicao> panacheCondicao = PanacheCondicao.findAll().list();
		return panacheCondicaoMapper.from(panacheCondicao);
	}

}
