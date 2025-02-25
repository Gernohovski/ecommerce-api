package br.com.fatecmogi.service.impl;

import br.com.fatecmogi.controller.dto.cartaoCredito.CadastrarCartaoCreditoClienteCommand;
import br.com.fatecmogi.controller.dto.cartaoCredito.EditarCartaoCreditoClienteCommand;
import br.com.fatecmogi.controller.exceptionHandler.CommandValidator;
import br.com.fatecmogi.controller.mapper.CartaoCreditoMapper;
import br.com.fatecmogi.model.entity.cartaoCredito.CartaoCredito;
import br.com.fatecmogi.model.exception.cartaoCredito.BandeiraCartaoNaoEncontrataException;
import br.com.fatecmogi.model.exception.cartaoCredito.CartaoCreditoClienteDiferenteException;
import br.com.fatecmogi.model.exception.cartaoCredito.CartaoCreditoNaoEncontratoException;
import br.com.fatecmogi.model.exception.cliente.ClienteNaoEncontratoException;
import br.com.fatecmogi.model.repository.BandeiraCartaoRepository;
import br.com.fatecmogi.model.repository.CartaoCreditoRepository;
import br.com.fatecmogi.model.repository.ClienteRepository;
import br.com.fatecmogi.service.CartaoCreditoService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.Objects;

@ApplicationScoped
public class CartaoCreditoServiceImpl implements CartaoCreditoService {

    @Inject
    CartaoCreditoRepository cartaoCreditoRepository;

    @Inject
    BandeiraCartaoRepository bandeiraCartaoRepository;

    @Inject
    ClienteRepository clienteRepository;

    @Inject
    CartaoCreditoMapper cartaoCreditoMapper;

    @Inject
    CommandValidator commandValidator;

    @Override
    @Transactional
    public CartaoCredito salvar(CadastrarCartaoCreditoClienteCommand command) {
        commandValidator.validate(command);
        var cliente = clienteRepository.findById(command.getClienteId()).orElseThrow(ClienteNaoEncontratoException::new);
        var bandeiraCartao = bandeiraCartaoRepository.findById(command.getBandeiraId()).orElseThrow(BandeiraCartaoNaoEncontrataException::new);
        var cartaoCredito = cartaoCreditoMapper.from(command);
        cartaoCredito.setCliente(cliente);
        cartaoCredito.setBandeira(bandeiraCartao);
        return cartaoCreditoRepository.save(cartaoCredito);
    }

    @Override
    @Transactional
    public CartaoCredito atualizar(Long id, EditarCartaoCreditoClienteCommand command) {
        commandValidator.validate(command);
        var cartaoCredito = cartaoCreditoRepository.findById(id).orElseThrow(CartaoCreditoNaoEncontratoException::new);
        if (Objects.equals(cartaoCredito.getCliente().getId(), command.getClienteId())) {
            throw new CartaoCreditoClienteDiferenteException();
        }
        cartaoCreditoMapper.update(cartaoCredito, command);
        return cartaoCreditoRepository.update(cartaoCredito);
    }

    @Override
    @Transactional
    public void deletar(Long id) {
        cartaoCreditoRepository.findById(id).orElseThrow(CartaoCreditoNaoEncontratoException::new);
        cartaoCreditoRepository.delete(id);
    }
}
