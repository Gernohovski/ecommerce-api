package br.com.fatecmogi.service.impl;

import br.com.fatecmogi.controller.dto.cupom.GerarCupomPromocionalCommand;
import br.com.fatecmogi.controller.exceptionHandler.CommandValidator;
import br.com.fatecmogi.controller.mapper.CupomPromocionalMapper;
import br.com.fatecmogi.model.entity.cupom.CupomPromocional;
import br.com.fatecmogi.model.entity.cupom.CupomTroca;
import br.com.fatecmogi.model.entity.pedido.SolicitacaoTroca;
import br.com.fatecmogi.model.exception.cliente.ClienteNaoEncontratoException;
import br.com.fatecmogi.model.exception.cupom.CodigoDoCupomJaCadastradoException;
import br.com.fatecmogi.model.exception.cupom.CupomExpiradoException;
import br.com.fatecmogi.model.exception.cupom.CupomNaoEncontradoException;
import br.com.fatecmogi.model.repository.ClienteRepository;
import br.com.fatecmogi.model.repository.CupomPromocionalRepository;
import br.com.fatecmogi.model.repository.CupomTrocaRepository;
import br.com.fatecmogi.service.CupomService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class CupomServiceImpl implements CupomService {

	@Inject
	CupomPromocionalRepository cupomPromocionalRepository;

	@Inject
	CupomTrocaRepository cupomTrocaRepository;

	@Inject
	CupomPromocionalMapper cupomPromocionalMapper;

	@Inject
	ClienteRepository clienteRepository;

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

	@Override
	public List<CupomTroca> buscarCuponsCliente(Long id) {
		return cupomTrocaRepository.findAllByClienteId(id);
	}

	@Override
	public void marcarComoUtilzados(List<CupomTroca> cuponsTroca) {
		cuponsTroca.forEach(cupom -> {
			cupom.setUtilizado(true);
			cupomTrocaRepository.update(cupom);
		});
	}

	@Override
	public CupomTroca gerarCupomTroca(SolicitacaoTroca solicitacaoTroca) {
		var valor = solicitacaoTroca.getItem()
			.stream()
			.map(item -> item.getItemPedido().getValor())
			.reduce(BigDecimal.ZERO, BigDecimal::add);
		var clienteId = solicitacaoTroca.getPedido().getCliente().getId();
		var cliente = clienteRepository.findById(clienteId).orElseThrow(ClienteNaoEncontratoException::new);
		var cupom = CupomTroca.builder().valorDesconto(valor).cliente(cliente).build();
		cupom.gerarCodigo();
		return cupomTrocaRepository.save(cupom);
	}

}
