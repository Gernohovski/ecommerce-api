package br.com.fatecmogi.service;

import br.com.fatecmogi.controller.dto.endereco.CadastrarEnderecoClienteCommand;
import br.com.fatecmogi.controller.dto.endereco.EditarEnderecoClienteCommand;
import br.com.fatecmogi.model.entity.endereco.Endereco;

public interface EnderecoService {

	Endereco salvar(CadastrarEnderecoClienteCommand command);

	Endereco atualizar(Long id, EditarEnderecoClienteCommand command);

	void deletar(Long id, String tipoEndereco);

	void tornarPrincipal(Long id, String tipoEndereco, Long clienteId);

}
