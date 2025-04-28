package br.com.fatecmogi.service;

import br.com.fatecmogi.controller.dto.frete.CalcularFreteCommand;
import br.com.fatecmogi.model.entity.frete.Frete;

public interface FreteService {

	Frete calcularFrete(CalcularFreteCommand command);

}
