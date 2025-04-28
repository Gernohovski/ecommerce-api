package br.com.fatecmogi.service.impl;

import br.com.fatecmogi.model.entity.cupom.CupomTroca;
import br.com.fatecmogi.model.entity.pedido.ItemPedido;
import br.com.fatecmogi.model.entity.pedido.SolicitacaoTroca;
import br.com.fatecmogi.model.exception.cliente.ClienteNaoEncontratoException;
import br.com.fatecmogi.model.repository.ClienteRepository;
import br.com.fatecmogi.model.repository.CupomTrocaRepository;
import br.com.fatecmogi.service.CupomTrocaService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.math.BigDecimal;

@ApplicationScoped
public class CupomTrocaServiceImpl implements CupomTrocaService {

	@Inject
	CupomTrocaRepository cupomTrocaRepository;

	@Inject
	ClienteRepository clienteRepository;

	@Override
	public CupomTroca gerarCupomTroca(SolicitacaoTroca solicitacaoTroca) {
		var valor = solicitacaoTroca.getItensPedido()
			.stream()
			.map(ItemPedido::getValor)
			.reduce(BigDecimal.ZERO, BigDecimal::add);
		var clienteId = solicitacaoTroca.getPedido().getCliente().getId();
		var cliente = clienteRepository.findById(clienteId).orElseThrow(ClienteNaoEncontratoException::new);
		var cupom = CupomTroca.builder().valorDesconto(valor).cliente(cliente).build();
		cupom.gerarCodigo();
		return cupomTrocaRepository.save(cupom);
	}

}
