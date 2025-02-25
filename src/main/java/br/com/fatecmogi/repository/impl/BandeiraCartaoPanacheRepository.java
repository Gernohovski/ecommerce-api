package br.com.fatecmogi.repository.impl;

import br.com.fatecmogi.model.entity.cartaoCredito.BandeiraCartao;
import br.com.fatecmogi.model.repository.BandeiraCartaoRepository;
import br.com.fatecmogi.repository.mapper.PanacheBandeiraCartaoMapper;
import br.com.fatecmogi.repository.table.PanacheBandeiraCartao;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BandeiraCartaoPanacheRepository implements BandeiraCartaoRepository {

    @Inject
    PanacheBandeiraCartaoMapper panacheBandeiraCartaoMapper;

    @Override
    public List<BandeiraCartao> findAll() {
        List<PanacheBandeiraCartao> panacheBandeiraCartao = PanacheBandeiraCartao.findAll().list();
        return panacheBandeiraCartaoMapper.from(panacheBandeiraCartao);
    }

    @Override
    public Optional<BandeiraCartao> findById(Long id) {
        PanacheBandeiraCartao panacheBandeiraCartao = PanacheBandeiraCartao.findById(id);
        if (panacheBandeiraCartao == null) {
            return Optional.empty();
        }
        return Optional.of(panacheBandeiraCartaoMapper.from(panacheBandeiraCartao));
    }

}
