package br.com.fatecmogi.service;

import br.com.fatecmogi.controller.dto.cliente.CadastrarClienteCommand;
import br.com.fatecmogi.controller.dto.cliente.EditarClienteCommand;
import br.com.fatecmogi.controller.dto.cliente.EditarSenhaClienteCommand;
import br.com.fatecmogi.controller.dto.cliente.FazerLoginCommand;
import br.com.fatecmogi.model.entity.cliente.Cliente;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ClienteService {

    Cliente salvar(CadastrarClienteCommand command);

    Cliente atualizar(Long id, EditarClienteCommand command);

    Cliente atualizarSenha(Long id, EditarSenhaClienteCommand command);

    Cliente inativar(Long id);

    void deletar(Long id);

    Cliente buscar(Long id);

    List<Cliente> filtrar(Long generoId, String nome, String cpf, String email);

    Cliente login(FazerLoginCommand command);

}
