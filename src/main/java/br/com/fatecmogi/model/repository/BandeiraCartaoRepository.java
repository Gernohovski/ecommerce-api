package br.com.fatecmogi.model.repository;

import br.com.fatecmogi.model.entity.cartaoCredito.BandeiraCartao;

import java.util.List;
import java.util.Optional;

public interface BandeiraCartaoRepository {

	List<BandeiraCartao> findAll();

	Optional<BandeiraCartao> findById(Long id);

}
