package br.com.fatecmogi.service;

import br.com.fatecmogi.controller.dto.cliente.CadastrarClienteCommand;
import br.com.fatecmogi.controller.dto.cliente.EditarClienteCommand;
import br.com.fatecmogi.controller.dto.cliente.FazerLoginCommand;
import br.com.fatecmogi.model.entity.cliente.Cliente;

import java.util.Optional;

public interface ClienteService {

    Cliente salvar(CadastrarClienteCommand command);

    Cliente atualizar(Long id, EditarClienteCommand command);

    Cliente inativar(Long id);

    void deletar(Long id);

    Cliente buscar(Long id);

    Cliente login(FazerLoginCommand command);

}
