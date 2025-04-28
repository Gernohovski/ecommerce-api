package br.com.fatecmogi.service;

import br.com.fatecmogi.controller.dto.cupom.GerarCupomPromocionalCommand;
import br.com.fatecmogi.model.entity.cupom.CupomPromocional;
import br.com.fatecmogi.model.entity.cupom.CupomTroca;

import java.util.List;

public interface CupomService {

	CupomPromocional gerarCupom(GerarCupomPromocionalCommand command);

	CupomPromocional buscarCupom(String codigo);

	List<CupomTroca> buscarCuponsCliente(Long id);

	void marcarComoUtilzados(List<CupomTroca> cuponsTroca);

}
