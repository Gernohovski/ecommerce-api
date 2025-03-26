package br.com.fatecmogi.service;

import br.com.fatecmogi.controller.dto.cliente.*;
import br.com.fatecmogi.model.entity.cliente.Cliente;

import java.util.List;

public interface ClienteService {

	Cliente salvar(CadastrarClienteCommand command);

	Cliente atualizar(Long id, EditarClienteCommand command);

	Cliente atualizarSenha(Long id, EditarSenhaClienteCommand command);

	Cliente inativar(Long id);

	void deletar(Long id);

	Cliente buscar(Long id);

	List<Cliente> filtrar(Long generoId, String nome, String cpf, String email);

	List<Cliente> filtrarPaginacao(FiltrarClienteCommand command);

	Cliente login(FazerLoginCommand command);

}
