package br.com.fatecmogi.service.impl;

import br.com.fatecmogi.model.entity.cartaoCredito.BandeiraCartao;
import br.com.fatecmogi.model.repository.BandeiraCartaoRepository;
import br.com.fatecmogi.service.BandeirasCartaoService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class BandeirasCartaoServiceImpl implements BandeirasCartaoService {

	@Inject
	BandeiraCartaoRepository bandeiraCartaoRepository;

	@Override
	public List<BandeiraCartao> findAll() {
		return bandeiraCartaoRepository.findAll();
	}

}
