package br.com.fatecmogi.service;

import br.com.fatecmogi.controller.dto.cartaoCredito.CadastrarCartaoCreditoClienteCommand;
import br.com.fatecmogi.controller.dto.cartaoCredito.EditarCartaoCreditoClienteCommand;
import br.com.fatecmogi.model.entity.cartaoCredito.CartaoCredito;

public interface CartaoCreditoService {

	CartaoCredito salvar(CadastrarCartaoCreditoClienteCommand command);

	CartaoCredito atualizar(Long id, EditarCartaoCreditoClienteCommand command);

	void deletar(Long id);

	void tornarPrincipal(Long id, Long clienteId);

}
