package br.com.fatecmogi.repository.impl;

import br.com.fatecmogi.model.entity.cartaoCredito.CartaoCredito;
import br.com.fatecmogi.model.repository.CartaoCreditoRepository;
import br.com.fatecmogi.repository.mapper.PanacheCartaoCreditoMapper;
import br.com.fatecmogi.repository.table.PanacheCartaoCredito;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Optional;

@ApplicationScoped
public class CartaoCreditoPanacheRepository implements CartaoCreditoRepository {

    @Inject
    PanacheCartaoCreditoMapper panacheCartaoCreditoMapper;

    @Override
    public CartaoCredito save(CartaoCredito cartaoCredito) {
        PanacheCartaoCredito panacheCartaoCredito = panacheCartaoCreditoMapper.from(cartaoCredito);
        panacheCartaoCredito.persist();
        return panacheCartaoCreditoMapper.from(panacheCartaoCredito);
    }

    @Override
    public CartaoCredito update(CartaoCredito cartaoCredito) {
        PanacheCartaoCredito panacheCartaoCredito = panacheCartaoCreditoMapper.from(cartaoCredito);
        panacheCartaoCredito.persist();
        return panacheCartaoCreditoMapper.from(panacheCartaoCredito);
    }

    @Override
    public Optional<CartaoCredito> findById(Long id) {
        PanacheCartaoCredito panacheCartaoCredito = PanacheCartaoCredito.findById(id);
        if (panacheCartaoCredito == null) {
            return Optional.empty();
        }
        return Optional.of(panacheCartaoCreditoMapper.from(panacheCartaoCredito));
    }

    @Override
    public void delete(Long id) {
        PanacheCartaoCredito.delete("crc_id", id);
    }

}
