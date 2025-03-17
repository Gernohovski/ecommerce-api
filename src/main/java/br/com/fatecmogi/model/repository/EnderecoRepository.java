package br.com.fatecmogi.model.repository;

import br.com.fatecmogi.model.entity.endereco.Endereco;
import br.com.fatecmogi.model.enums.TipoEndereco;

import java.util.List;
import java.util.Optional;

public interface EnderecoRepository {

	Endereco save(Endereco endereco);

	Endereco update(Endereco endereco);

	void delete(Long id, TipoEndereco tipoEndereco);

	Optional<Endereco> findById(Long id, TipoEndereco tipoEndereco);

	List<Endereco> findAllByCliente(Long clienteId, TipoEndereco tipoEndereco);

}
