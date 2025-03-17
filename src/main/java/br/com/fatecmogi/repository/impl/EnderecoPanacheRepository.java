package br.com.fatecmogi.repository.impl;

import br.com.fatecmogi.model.entity.endereco.Endereco;
import br.com.fatecmogi.model.entity.endereco.EnderecoCobranca;
import br.com.fatecmogi.model.entity.endereco.EnderecoEntrega;
import br.com.fatecmogi.model.entity.endereco.EnderecoResidencial;
import br.com.fatecmogi.model.enums.TipoEndereco;
import br.com.fatecmogi.model.repository.EnderecoRepository;
import br.com.fatecmogi.repository.mapper.PanacheEnderecoMapper;
import br.com.fatecmogi.repository.table.PanacheCliente;
import br.com.fatecmogi.repository.table.PanacheEnderecoCobranca;
import br.com.fatecmogi.repository.table.PanacheEnderecoEntrega;
import br.com.fatecmogi.repository.table.PanacheEnderecoResidencial;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class EnderecoPanacheRepository implements EnderecoRepository {

    @Inject
    PanacheEnderecoMapper panacheEnderecoMapper;

    @Override
    public Endereco save(Endereco endereco) {
        PanacheCliente panacheCliente = PanacheCliente.findById(endereco.getCliente().getId());
        if (endereco instanceof EnderecoResidencial) {
            PanacheEnderecoResidencial panacheEnderecoResidencial = panacheEnderecoMapper.fromEnderecoResidencial((EnderecoResidencial) endereco);
            panacheEnderecoResidencial.setCliente(panacheCliente);
            panacheEnderecoResidencial.persist();
            return panacheEnderecoMapper.from(panacheEnderecoResidencial);
        } else if (endereco instanceof EnderecoCobranca) {
            PanacheEnderecoCobranca panacheEnderecoCobranca = panacheEnderecoMapper.fromEnderecoCobranca((EnderecoCobranca) endereco);
            panacheEnderecoCobranca.setCliente(panacheCliente);
            panacheEnderecoCobranca.persist();
            return panacheEnderecoMapper.from(panacheEnderecoCobranca);
        } else {
            PanacheEnderecoEntrega panacheEnderecoEntrega = panacheEnderecoMapper.fromEnderecoEntrega((EnderecoEntrega) endereco);
            panacheEnderecoEntrega.setCliente(panacheCliente);
            panacheEnderecoEntrega.persist();
            return panacheEnderecoMapper.from(panacheEnderecoEntrega);
        }
    }

    @Override
    public Endereco update(Endereco endereco) {
        if (endereco instanceof EnderecoResidencial) {
            PanacheEnderecoResidencial panacheEnderecoResidencialSalvo = PanacheEnderecoResidencial.findById(endereco.getId());
            panacheEnderecoResidencialSalvo.unreferrenceDependecies();
            PanacheEnderecoResidencial panacheEnderecoResidencial = panacheEnderecoMapper.updateEnderecoResidencial(panacheEnderecoResidencialSalvo, endereco);
            panacheEnderecoResidencial.persist();
            return panacheEnderecoMapper.from(panacheEnderecoResidencial);
        } else if (endereco instanceof EnderecoCobranca) {
            PanacheEnderecoCobranca panacheEnderecoCobrancaSalvo = PanacheEnderecoCobranca.findById(endereco.getId());
            panacheEnderecoCobrancaSalvo.unreferrenceDependecies();
            PanacheEnderecoCobranca panacheEnderecoCobranca = panacheEnderecoMapper.updateEnderecoCobranca(panacheEnderecoCobrancaSalvo, endereco);
            panacheEnderecoCobranca.persist();
            return panacheEnderecoMapper.from(panacheEnderecoCobranca);
        } else {
            PanacheEnderecoEntrega panacheEnderecoEntregaSalvo = PanacheEnderecoEntrega.findById(endereco.getId());
            panacheEnderecoEntregaSalvo.unreferrenceDependecies();
            PanacheEnderecoEntrega panacheEnderecoEntrega = panacheEnderecoMapper.updateEnderecoEntrega(panacheEnderecoEntregaSalvo, endereco);
            panacheEnderecoEntrega.persist();
            return panacheEnderecoMapper.from(panacheEnderecoEntrega);
        }
    }

    @Override
    public void delete(Long id, TipoEndereco tipoEndereco) {
        switch (tipoEndereco) {
            case RESIDENCIAL -> PanacheEnderecoResidencial.delete("id", id);
            case COBRANCA -> PanacheEnderecoCobranca.delete("id", id);
            case ENTREGA -> PanacheEnderecoEntrega.delete("id", id);
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

    @Override
    public List<Endereco> findAllByCliente(Long clienteId, TipoEndereco tipoEndereco) {
        List<Endereco> enderecos = new ArrayList<>();
        switch (tipoEndereco) {
            case RESIDENCIAL -> {
                List<PanacheEnderecoResidencial> enderecosResidenciais = PanacheEnderecoResidencial.find("cliente.id", clienteId).list();
                enderecos = panacheEnderecoMapper.fromEnderecoResidencial(enderecosResidenciais);
            }
            case COBRANCA -> {
                List<PanacheEnderecoCobranca> enderecoCobrancas = PanacheEnderecoCobranca.find("cliente.id", clienteId).list();
                enderecos = panacheEnderecoMapper.fromEnderecoCobranca(enderecoCobrancas);
            }
            case ENTREGA -> {
                List<PanacheEnderecoEntrega> enderecoEntregas = PanacheEnderecoEntrega.find("cliente.id", clienteId).list();
                enderecos = panacheEnderecoMapper.fromEnderecoEntrega(enderecoEntregas);
            }
        }
        return enderecos;
    }

}
