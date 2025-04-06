package br.com.fatecmogi.service;

import br.com.fatecmogi.controller.dto.cupom.GerarCupomPromocionalCommand;
import br.com.fatecmogi.model.entity.cupom.CupomPromocional;

public interface CupomService {

	CupomPromocional gerarCupom(GerarCupomPromocionalCommand command);

	CupomPromocional buscarCupom(String codigo);

}
