package br.com.fatecmogi.model.repository;

import br.com.fatecmogi.controller.dto.cliente.FiltrarClienteCommand;
import br.com.fatecmogi.model.entity.cliente.Cliente;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ClienteRepository {

	Cliente save(Cliente cliente);

	List<Cliente> findAll();

	List<Cliente> findAllByExample(Cliente cliente);

	List<Cliente> findAllWithPagination(FiltrarClienteCommand command);

	boolean existsByCpf(String cpf);

	boolean existsByEmail(String email);

	Optional<Cliente> findById(Long id);

	Cliente update(Cliente cliente);

	void delete(Cliente cliente);

	Optional<Cliente> findByEmail(String email);

	Long buscarVendasPorPeriodo(LocalDateTime dataInicio, LocalDateTime dataFim);

}
