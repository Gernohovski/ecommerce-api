package br.com.fatecmogi.repository.impl;

import br.com.fatecmogi.model.entity.cliente.Cliente;
import br.com.fatecmogi.model.repository.ClienteRepository;
import br.com.fatecmogi.repository.mapper.PanacheClienteMapper;
import br.com.fatecmogi.repository.mapper.PanacheTelefoneMapper;
import br.com.fatecmogi.repository.table.*;
import io.quarkus.hibernate.orm.panache.Panache;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@ApplicationScoped
public class ClientePanacheRepository implements ClienteRepository {

    @Inject
    PanacheClienteMapper panacheClienteMapper;

    @Inject
    PanacheTelefoneMapper panacheTelefoneMapper;

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
    public List<Cliente> findAllByExample(Cliente cliente) {
        StringBuilder query = new StringBuilder("from PanacheCliente u where 1=1");
        Map<String, Object> params = new HashMap<>();
        if (cliente.getGenero() != null && cliente.getGenero().getId() != null) {
            query.append(" and u.genero.id = :generoId");
            params.put("generoId", cliente.getGenero().getId());
        }
        if (cliente.getNome() != null && !cliente.getNome().isEmpty()) {
            query.append(" and u.nome like :nome");
            params.put("nome", "%" + cliente.getNome() + "%");
        }
        if (cliente.getCpf() != null && !cliente.getCpf().isEmpty()) {
            query.append(" and u.cpf like :cpf");
            params.put("cpf", "%" + cliente.getCpf() + "%");
        }
        if (cliente.getEmail() != null && !cliente.getEmail().isEmpty()) {
            query.append(" and u.email like :email");
            params.put("email", "%" + cliente.getEmail() + "%");
        }
        List<PanacheCliente> panacheCliente = PanacheCliente.find(query.toString(), params).list();
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
        PanacheCliente panacheCliente = PanacheCliente.findById(cliente.getId());
        panacheCliente.unreferrenceDependecies();
        panacheCliente = panacheClienteMapper.update(panacheCliente, cliente);
        PanacheTelefone panacheTelefone = PanacheTelefone.findById(panacheCliente.getTelefone().getId());
        panacheTelefone.unreferrenceDependecies();
        panacheTelefone = panacheTelefoneMapper.update(panacheTelefone, cliente.getTelefone());
        panacheTelefone.persist();
        panacheCliente.persist();
        return panacheClienteMapper.from(panacheCliente);
    }

    @Override
    public void delete(Cliente cliente) {
        PanacheCliente panacheCliente = PanacheCliente.findById(cliente.getId());
        panacheCliente.deleteDependecies();
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
