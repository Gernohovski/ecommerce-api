package br.com.fatecmogi.service.impl;

import br.com.fatecmogi.controller.dto.cliente.CadastrarClienteCommand;
import br.com.fatecmogi.controller.dto.cliente.EditarClienteCommand;
import br.com.fatecmogi.controller.dto.cliente.FazerLoginCommand;
import br.com.fatecmogi.controller.exceptionHandler.CommandValidator;
import br.com.fatecmogi.controller.mapper.ClienteMapper;
import br.com.fatecmogi.model.entity.cliente.Cliente;
import br.com.fatecmogi.model.entity.endereco.EnderecoResidencial;
import br.com.fatecmogi.model.exception.cliente.ClienteNaoEncontratoException;
import br.com.fatecmogi.model.exception.cliente.GeneroNaoEncontradoException;
import br.com.fatecmogi.model.exception.cliente.SenhaClienteInvalidaException;
import br.com.fatecmogi.model.repository.ClienteRepository;
import br.com.fatecmogi.model.repository.GeneroRepository;
import br.com.fatecmogi.service.ClienteService;
import br.com.fatecmogi.service.SenhaService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.Optional;

@ApplicationScoped
public class ClienteServiceImpl implements ClienteService {

    @Inject
    ClienteRepository clienteRepository;

    @Inject
    GeneroRepository generoRepository;

    @Inject
    ClienteMapper clienteMapper;

    @Inject
    CommandValidator commandValidator;

    @Inject
    SenhaService senhaService;

    @Override
    @Transactional
    public Cliente salvar(CadastrarClienteCommand command) {
        commandValidator.validate(command);
        var genero = generoRepository.findById(command.getGeneroId()).orElseThrow(GeneroNaoEncontradoException::new);
        var cliente = clienteMapper.from(command);
        cliente.setGenero(genero);
        cliente.setSenha(senhaService.encriptarSenha(cliente.getSenha()));
        return clienteRepository.save(cliente);
    }

    @Override
    @Transactional
    public Cliente atualizar(Long id, EditarClienteCommand command) {
        commandValidator.validate(command);
        var cliente = clienteRepository.findById(id).orElseThrow(ClienteNaoEncontratoException::new);
        var genero = generoRepository.findById(command.getGeneroId()).orElseThrow(GeneroNaoEncontradoException::new);
        var clienteAtualizado = clienteMapper.update(cliente, command);
        clienteAtualizado.setGenero(genero);
        clienteAtualizado.setSenha(senhaService.encriptarSenha(clienteAtualizado.getSenha()));
        return clienteRepository.update(clienteAtualizado);
    }

    @Override
    @Transactional
    public Cliente inativar(Long id) {
        var cliente = clienteRepository.findById(id).orElseThrow(ClienteNaoEncontratoException::new);
        cliente.setAtivo(false);
        return clienteRepository.update(cliente);
    }

    @Override
    @Transactional
    public void deletar(Long id) {
        var cliente = clienteRepository.findById(id).orElseThrow(ClienteNaoEncontratoException::new);
        clienteRepository.delete(cliente);
    }

    @Override
    public Cliente buscar(Long id) {
        return clienteRepository.findById(id).orElseThrow(ClienteNaoEncontratoException::new);
    }

    @Override
    public Cliente login(FazerLoginCommand command) {
        var cliente = clienteRepository.findByEmail(command.getEmail()).orElseThrow(ClienteNaoEncontratoException::new);
        if(!senhaService.validarSenha(command.getSenha(), cliente.getSenha())) {
            throw new SenhaClienteInvalidaException();
        }
        return cliente;
    }

}
