package br.com.fatecmogi.service.impl;

import br.com.fatecmogi.controller.dto.endereco.CadastrarEnderecoClienteCommand;
import br.com.fatecmogi.controller.dto.endereco.EditarEnderecoClienteCommand;
import br.com.fatecmogi.controller.exceptionHandler.CommandValidator;
import br.com.fatecmogi.controller.mapper.EnderecoMapper;
import br.com.fatecmogi.model.entity.endereco.Endereco;
import br.com.fatecmogi.model.entity.endereco.EnderecoCobranca;
import br.com.fatecmogi.model.entity.endereco.EnderecoEntrega;
import br.com.fatecmogi.model.entity.endereco.EnderecoResidencial;
import br.com.fatecmogi.model.enums.TipoEndereco;
import br.com.fatecmogi.model.exception.cliente.ClienteNaoEncontratoException;
import br.com.fatecmogi.model.exception.endereco.*;
import br.com.fatecmogi.model.repository.ClienteRepository;
import br.com.fatecmogi.model.repository.EnderecoRepository;
import br.com.fatecmogi.model.repository.TipoLogradouroRepository;
import br.com.fatecmogi.model.repository.TipoResidenciaRepository;
import br.com.fatecmogi.service.EnderecoService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.Objects;

@ApplicationScoped
public class EnderecoServiceImpl implements EnderecoService {

    @Inject
    ClienteRepository clienteRepository;

    @Inject
    TipoLogradouroRepository tipoLogradouroRepository;

    @Inject
    TipoResidenciaRepository tipoResidenciaRepository;

    @Inject
    EnderecoRepository enderecoRepository;

    @Inject
    EnderecoMapper enderecoMapper;

    @Inject
    CommandValidator commandValidator;

    @Override
    @Transactional
    public Endereco salvar(CadastrarEnderecoClienteCommand command) {
        commandValidator.validate(command);
        var cliente = clienteRepository.findById(command.getClienteId()).orElseThrow(ClienteNaoEncontratoException::new);
        var tipoLogradouro = tipoLogradouroRepository.findById(command.getTipoLogradouroId()).orElseThrow(TipoLogradouroNaoEncontratoException::new);
        var tipoResidencia = tipoResidenciaRepository.findById(command.getTipoResidenciaId()).orElseThrow(TipoResidenciaNaoEncontratoException::new);
        TipoEndereco tipoEndereco;
        try {
            tipoEndereco = TipoEndereco.valueOf(command.getTipoEndereco());
        } catch (Exception e) {
            throw new TipoEnderecoNaoEncontratoException();
        }
        Endereco endereco = null;
        switch (tipoEndereco) {
            case RESIDENCIAL -> endereco = enderecoMapper.toEnderecoResidencial(command);
            case ENTREGA -> endereco = enderecoMapper.toEnderecoEntrega(command);
            case COBRANCA -> endereco = enderecoMapper.toEnderecoCobranca(command);
        }
        endereco.setCliente(cliente);
        endereco.setTipoLogradouro(tipoLogradouro);
        endereco.setTipoResidencia(tipoResidencia);
        return enderecoRepository.save(endereco);
    }

    @Override
    @Transactional
    public Endereco atualizar(Long id, EditarEnderecoClienteCommand command) {
        commandValidator.validate(command);
        TipoEndereco tipoEndereco;
        try {
            tipoEndereco = TipoEndereco.valueOf(command.getTipoEndereco());
        } catch (Exception e) {
            throw new TipoEnderecoNaoEncontratoException();
        }
        var endereco = enderecoRepository.findById(id, tipoEndereco);
        var cliente = clienteRepository.findById(command.getClienteId()).orElseThrow(ClienteNaoEncontratoException::new);
        var tipoLogradouro = tipoLogradouroRepository.findById(command.getTipoLogradouroId()).orElseThrow(TipoLogradouroNaoEncontratoException::new);
        var tipoResidencia = tipoResidenciaRepository.findById(command.getTipoResidenciaId()).orElseThrow(TipoResidenciaNaoEncontratoException::new);
        Endereco enderecoAtualizado = null;
        if(endereco.isPresent()) {
            switch (tipoEndereco) {
                case RESIDENCIAL ->
                        enderecoAtualizado = enderecoMapper.updateEnderecoResidencial((EnderecoResidencial) endereco.get(), command);
                case ENTREGA ->
                        enderecoAtualizado = enderecoMapper.updateEnderecoEntrega((EnderecoEntrega) endereco.get(),command);
                case COBRANCA ->
                        enderecoAtualizado = enderecoMapper.updateEnderecoCobranca((EnderecoCobranca) endereco.get(),command);
            }
        }
        if(enderecoAtualizado != null) {
            enderecoAtualizado.setCliente(cliente);
            enderecoAtualizado.setTipoLogradouro(tipoLogradouro);
            enderecoAtualizado.setTipoResidencia(tipoResidencia);
        }
        return enderecoRepository.update(enderecoAtualizado);
    }


    @Override
    @Transactional
    public void deletar(Long id, String tipo) {
        TipoEndereco tipoEndereco;
        try {
            tipoEndereco = TipoEndereco.valueOf(tipo);
        } catch (Exception e) {
            throw new TipoEnderecoNaoEncontratoException();
        }
        enderecoRepository.delete(id, tipoEndereco);
    }

    @Override
    @Transactional
    public void tornarPrincipal(Long id, String tipo, Long clienteId) {
        TipoEndereco tipoEndereco;
        try {
            tipoEndereco = TipoEndereco.valueOf(tipo);
        } catch (Exception e) {
            throw new TipoEnderecoNaoEncontratoException();
        }
        var endereco = enderecoRepository.findById(id, tipoEndereco).orElseThrow(EnderecoNaoEncontradoException::new);
        var enderecosCliente = enderecoRepository.findAllByCliente(clienteId, tipoEndereco);
        enderecosCliente.forEach(enderecoCliente -> {
            if(!Objects.equals(enderecoCliente.getId(), id)){
                enderecoCliente.setPrincipal(false);
                enderecoRepository.update(enderecoCliente);
            }
        });
        endereco.setPrincipal(true);
        enderecoRepository.update(endereco);
    }

}
