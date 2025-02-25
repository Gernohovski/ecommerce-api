package br.com.fatecmogi.repository.impl;

import br.com.fatecmogi.model.entity.cliente.Cliente;
import br.com.fatecmogi.model.repository.ClienteRepository;
import br.com.fatecmogi.repository.mapper.PanacheClienteMapper;
import br.com.fatecmogi.repository.table.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ClientePanacheRepository implements ClienteRepository {

    @Inject
    PanacheClienteMapper panacheClienteMapper;

    @Override
    public Cliente save(Cliente cliente) {
        PanacheCliente panacheCliente = panacheClienteMapper.from(cliente);
        panacheCliente.getEnderecoResidencial().forEach(endereco -> endereco.setCliente(panacheCliente));
        panacheCliente.getEnderecoCobranca().forEach(endereco -> endereco.setCliente(panacheCliente));
        panacheCliente.getEnderecoEntrega().forEach(endereco -> endereco.setCliente(panacheCliente));
        panacheCliente.getCartaoCredito().forEach(cartao -> cartao.setCliente(panacheCliente));
        panacheCliente.persistDependecies();
        panacheCliente.persist();
        return panacheClienteMapper.from(panacheCliente);
    }

    @Override
    public List<Cliente> findAll() {
        List<PanacheCliente> panacheCliente = PanacheCliente.findAll().list();
        return panacheClienteMapper.from(panacheCliente);
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        PanacheCliente panacheCliente = PanacheCliente.findById(id);
        if (panacheCliente == null) {
            return Optional.empty();
        }
        return Optional.of(panacheClienteMapper.from(panacheCliente));
    }

    @Override
    public Cliente update(Cliente cliente) {
        PanacheCliente panacheCliente = panacheClienteMapper.from(cliente);
        panacheCliente.persistDependecies();
        panacheCliente.persist();
        return panacheClienteMapper.from(panacheCliente);
    }

    @Override
    public void delete(Cliente cliente) {
        PanacheCliente panacheCliente = panacheClienteMapper.from(cliente);
        panacheCliente.unreferrenceDependecies();
        panacheCliente.delete();
    }

    @Override
    public Optional<Cliente> findByEmail(String email) {
        PanacheCliente panacheCliente = PanacheCliente.find("email", email).firstResult();
        if (panacheCliente == null) {
            return Optional.empty();
        }
        return Optional.of(panacheClienteMapper.from(panacheCliente));
    }

}
