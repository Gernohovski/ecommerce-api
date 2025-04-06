package br.com.fatecmogi.service.impl;

import br.com.fatecmogi.controller.dto.cupom.GerarCupomPromocionalCommand;
import br.com.fatecmogi.controller.exceptionHandler.CommandValidator;
import br.com.fatecmogi.controller.mapper.CupomPromocionalMapper;
import br.com.fatecmogi.model.entity.cupom.CupomPromocional;
import br.com.fatecmogi.model.exception.cupom.CodigoDoCupomJaCadastradoException;
import br.com.fatecmogi.model.exception.cupom.CupomExpiradoException;
import br.com.fatecmogi.model.exception.cupom.CupomNaoEncontradoException;
import br.com.fatecmogi.model.repository.CupomPromocionalRepository;
import br.com.fatecmogi.service.CupomService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;

@ApplicationScoped
public class CupomServiceImpl implements CupomService {

	@Inject
	CupomPromocionalRepository cupomPromocionalRepository;

	@Inject
	CupomPromocionalMapper cupomPromocionalMapper;

	@Inject
	CommandValidator commandValidator;

	@Override
	@Transactional
	public CupomPromocional gerarCupom(GerarCupomPromocionalCommand command) {
		commandValidator.validate(command);
		if (cupomPromocionalRepository.existsByCodigo(command.getCodigo())) {
			throw new CodigoDoCupomJaCadastradoException();
		}
		var cupom = cupomPromocionalMapper.from(command);
		return cupomPromocionalRepository.save(cupom);
	}

	@Override
	@Transactional
	public CupomPromocional buscarCupom(String codigo) {
		var cupom = cupomPromocionalRepository.findByCodigo(codigo).orElseThrow(CupomNaoEncontradoException::new);
		if (cupom.getDataExpiracao().isBefore(LocalDateTime.now())) {
			throw new CupomExpiradoException();
		}
		return cupom;
	}

}
