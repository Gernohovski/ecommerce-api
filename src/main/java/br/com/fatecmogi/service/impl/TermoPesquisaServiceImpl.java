package br.com.fatecmogi.service.impl;

import br.com.fatecmogi.service.TermoPesquisaService;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class TermoPesquisaServiceImpl implements TermoPesquisaService {

	@Override
	public String calcularTermoPesquisa(List<String> parametros) {
		StringBuilder termoPesquisa = new StringBuilder();
		parametros.forEach(parametro -> {
			termoPesquisa.append(parametro.toUpperCase());
		});
		return termoPesquisa.toString();
	}

}
