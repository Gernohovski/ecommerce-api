package br.com.fatecmogi.repository.impl;

import br.com.fatecmogi.model.entity.endereco.Endereco;
import br.com.fatecmogi.model.entity.endereco.EnderecoCobranca;
import br.com.fatecmogi.model.entity.endereco.EnderecoEntrega;
import br.com.fatecmogi.model.entity.endereco.EnderecoResidencial;
import br.com.fatecmogi.model.enums.TipoEndereco;
import br.com.fatecmogi.model.repository.EnderecoRepository;
import br.com.fatecmogi.repository.mapper.PanacheEnderecoMapper;
import br.com.fatecmogi.repository.table.PanacheEnderecoCobranca;
import br.com.fatecmogi.repository.table.PanacheEnderecoEntrega;
import br.com.fatecmogi.repository.table.PanacheEnderecoResidencial;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Optional;

@ApplicationScoped
public class EnderecoPanacheRepository implements EnderecoRepository {

    @Inject
    PanacheEnderecoMapper panacheEnderecoMapper;

    @Override
    public Endereco save(Endereco endereco) {
        if (endereco instanceof EnderecoResidencial) {
            PanacheEnderecoResidencial panacheEnderecoResidencial = panacheEnderecoMapper.fromEnderecoResidencial((EnderecoResidencial) endereco);
            panacheEnderecoResidencial.persist();
            return panacheEnderecoMapper.from(panacheEnderecoResidencial);
        } else if (endereco instanceof EnderecoCobranca) {
            PanacheEnderecoCobranca panacheEnderecoCobranca = panacheEnderecoMapper.fromEnderecoCobranca((EnderecoCobranca) endereco);
            panacheEnderecoCobranca.persist();
            return panacheEnderecoMapper.from(panacheEnderecoCobranca);
        } else {
            PanacheEnderecoEntrega panacheEnderecoEntrega = panacheEnderecoMapper.fromEnderecoEntrega((EnderecoEntrega) endereco);
            panacheEnderecoEntrega.persist();
            return panacheEnderecoMapper.from(panacheEnderecoEntrega);
        }
    }

    @Override
    public Endereco update(Endereco endereco) {
        if (endereco instanceof EnderecoResidencial) {
            PanacheEnderecoResidencial panacheEnderecoResidencial = panacheEnderecoMapper.fromEnderecoResidencial((EnderecoResidencial) endereco);
            panacheEnderecoResidencial.persist();
            return panacheEnderecoMapper.from(panacheEnderecoResidencial);
        } else if (endereco instanceof EnderecoCobranca) {
            PanacheEnderecoCobranca panacheEnderecoCobranca = panacheEnderecoMapper.fromEnderecoCobranca((EnderecoCobranca) endereco);
            panacheEnderecoCobranca.persist();
            return panacheEnderecoMapper.from(panacheEnderecoCobranca);
        } else {
            PanacheEnderecoEntrega panacheEnderecoEntrega = panacheEnderecoMapper.fromEnderecoEntrega((EnderecoEntrega) endereco);
            panacheEnderecoEntrega.persist();
            return panacheEnderecoMapper.from(panacheEnderecoEntrega);
        }
    }

    @Override
    public void delete(Long id, TipoEndereco tipoEndereco) {
        switch (tipoEndereco) {
            case RESIDENCIAL -> PanacheEnderecoResidencial.delete("ers_id", id);
            case COBRANCA -> PanacheEnderecoCobranca.delete("ecb_id", id);
            case ENTREGA -> PanacheEnderecoEntrega.delete("eet_id", id);
        }
    }

    @Override
    public Optional<Endereco> findById(Long id, TipoEndereco tipoEndereco) {
        Endereco endereco = null;
        switch (tipoEndereco) {
            case RESIDENCIAL -> endereco = panacheEnderecoMapper.from((PanacheEnderecoResidencial) PanacheEnderecoResidencial.findById(id));
            case COBRANCA -> endereco = panacheEnderecoMapper.from((PanacheEnderecoCobranca) PanacheEnderecoCobranca.findById(id));
            case ENTREGA -> endereco = panacheEnderecoMapper.from((PanacheEnderecoEntrega) PanacheEnderecoEntrega.findById(id));
        }
        if(endereco == null) {
            return Optional.empty();
        }
        return Optional.of(endereco);
    }

}
