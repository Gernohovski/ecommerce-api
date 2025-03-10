package br.com.fatecmogi.model.repository;

import br.com.fatecmogi.model.entity.cliente.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository {

    Cliente save(Cliente cliente);

    List<Cliente> findAll();

    List<Cliente> findAllByExample(Cliente cliente);

    Optional<Cliente> findById(Long id);

    Cliente update(Cliente cliente);

    void delete(Cliente cliente);

    Optional<Cliente> findByEmail(String email);

}
