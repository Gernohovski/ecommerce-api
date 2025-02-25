package br.com.fatecmogi.model.repository;

import br.com.fatecmogi.model.entity.cartaoCredito.CartaoCredito;

import java.util.Optional;

public interface CartaoCreditoRepository {

    CartaoCredito save(CartaoCredito cartaoCredito);

    CartaoCredito update(CartaoCredito cartaoCredito);

    Optional<CartaoCredito> findById(Long id);

    void delete(Long id);

}
