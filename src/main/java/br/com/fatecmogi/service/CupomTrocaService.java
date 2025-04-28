package br.com.fatecmogi.service;

import br.com.fatecmogi.model.entity.cupom.CupomTroca;
import br.com.fatecmogi.model.entity.pedido.SolicitacaoTroca;

public interface CupomTrocaService {

	CupomTroca gerarCupomTroca(SolicitacaoTroca solicitacaoTroca);

}
