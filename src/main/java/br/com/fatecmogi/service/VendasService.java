package br.com.fatecmogi.service;

import br.com.fatecmogi.controller.dto.vendas.FiltrarVendasCommand;
import br.com.fatecmogi.controller.dto.vendas.VendasResponseDTO;

public interface VendasService {

	VendasResponseDTO filtrarVendas(FiltrarVendasCommand command);

}
