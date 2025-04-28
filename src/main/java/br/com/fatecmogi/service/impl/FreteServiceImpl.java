package br.com.fatecmogi.service.impl;

import br.com.fatecmogi.controller.dto.frete.CalcularFreteCommand;
import br.com.fatecmogi.model.entity.frete.Frete;
import br.com.fatecmogi.model.enums.TipoEndereco;
import br.com.fatecmogi.model.exception.endereco.EnderecoNaoEncontradoException;
import br.com.fatecmogi.model.repository.EnderecoRepository;
import br.com.fatecmogi.service.FreteService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class FreteServiceImpl implements FreteService {

	@Inject
	EnderecoRepository enderecoRepository;

	private static final String CEP_ORIGEM = "08780640";

	@Override
	public Frete calcularFrete(CalcularFreteCommand command) {
		var endereco = enderecoRepository.findById(command.getEnderecoId(), TipoEndereco.ENTREGA)
			.orElseThrow(EnderecoNaoEncontradoException::new);
		double base = 10.0;
		double pesoTaxa = command.getPeso() * 2.5;
		int dist = Math
			.abs(Integer.parseInt(endereco.getCep().substring(0, 2)) - Integer.parseInt(CEP_ORIGEM.substring(0, 2)));
		double distanciaTaxa = dist * 1.5;
		double total = base + pesoTaxa + distanciaTaxa;
		int prazo = 2 + dist / 5;

		return Frete.builder().valorFrete(total).prazoDias(prazo).build();
	}

}
