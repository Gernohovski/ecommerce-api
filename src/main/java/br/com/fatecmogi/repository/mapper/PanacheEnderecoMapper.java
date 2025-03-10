package br.com.fatecmogi.repository.mapper;

import br.com.fatecmogi.model.entity.endereco.*;
import br.com.fatecmogi.repository.table.PanacheEnderecoCobranca;
import br.com.fatecmogi.repository.table.PanacheEnderecoEntrega;
import br.com.fatecmogi.repository.table.PanacheEnderecoResidencial;
import org.mapstruct.*;

@Mapper(componentModel = "cdi", uses = PanacheClienteMapper.class)
public interface PanacheEnderecoMapper {

    @Mapping(target = "bairro", source = "bairro.nome")
    @Mapping(target = "cidade", source = "bairro.cidade.nome")
    @Mapping(target = "estado", source = "bairro.cidade.estado.nome")
    @Mapping(target = "pais", source = "bairro.cidade.estado.pais.nome")
    @Mapping(target = "cliente", ignore = true)
    PanacheEnderecoResidencial fromEnderecoResidencial(EnderecoResidencial endereco);

    @Mapping(target = "bairro", source = "bairro.nome")
    @Mapping(target = "cidade", source = "bairro.cidade.nome")
    @Mapping(target = "estado", source = "bairro.cidade.estado.nome")
    @Mapping(target = "pais", source = "bairro.cidade.estado.pais.nome")
    @Mapping(target = "cliente", ignore = true)
    PanacheEnderecoResidencial updateEnderecoResidencial(@MappingTarget PanacheEnderecoResidencial panacheEnderecoResidencial, Endereco endereco);

    @Mapping(target = "bairro.nome", source = "bairro")
    @Mapping(target = "bairro.cidade.nome", source = "cidade")
    @Mapping(target = "bairro.cidade.estado.nome", source = "estado")
    @Mapping(target = "bairro.cidade.estado.pais.nome", source = "pais")
    @Mapping(target = "cliente", ignore = true)
    EnderecoResidencial from(PanacheEnderecoResidencial panacheEnderecoResidencial);

    @Mapping(target = "bairro", source = "bairro.nome")
    @Mapping(target = "cidade", source = "bairro.cidade.nome")
    @Mapping(target = "estado", source = "bairro.cidade.estado.nome")
    @Mapping(target = "pais", source = "bairro.cidade.estado.pais.nome")
    @Mapping(target = "cliente", ignore = true)
    PanacheEnderecoCobranca fromEnderecoCobranca(EnderecoCobranca endereco);

    @Mapping(target = "bairro", source = "bairro.nome")
    @Mapping(target = "cidade", source = "bairro.cidade.nome")
    @Mapping(target = "estado", source = "bairro.cidade.estado.nome")
    @Mapping(target = "pais", source = "bairro.cidade.estado.pais.nome")
    @Mapping(target = "cliente", ignore = true)
    PanacheEnderecoCobranca updateEnderecoCobranca(@MappingTarget PanacheEnderecoCobranca panacheEnderecoCobranca, Endereco endereco);

    @Mapping(target = "bairro.nome", source = "bairro")
    @Mapping(target = "bairro.cidade.nome", source = "cidade")
    @Mapping(target = "bairro.cidade.estado.nome", source = "estado")
    @Mapping(target = "bairro.cidade.estado.pais.nome", source = "pais")
    @Mapping(target = "cliente", ignore = true)
    EnderecoCobranca from(PanacheEnderecoCobranca panacheEnderecoCobranca);

    @Mapping(target = "bairro", source = "bairro.nome")
    @Mapping(target = "cidade", source = "bairro.cidade.nome")
    @Mapping(target = "estado", source = "bairro.cidade.estado.nome")
    @Mapping(target = "pais", source = "bairro.cidade.estado.pais.nome")
    @Mapping(target = "cliente", ignore = true)
    PanacheEnderecoEntrega fromEnderecoEntrega(EnderecoEntrega endereco);

    @Mapping(target = "bairro", source = "bairro.nome")
    @Mapping(target = "cidade", source = "bairro.cidade.nome")
    @Mapping(target = "estado", source = "bairro.cidade.estado.nome")
    @Mapping(target = "pais", source = "bairro.cidade.estado.pais.nome")
    @Mapping(target = "cliente", ignore = true)
    PanacheEnderecoEntrega updateEnderecoEntrega(@MappingTarget PanacheEnderecoEntrega panacheEnderecoEntrega, Endereco endereco);


    @Mapping(target = "bairro.nome", source = "bairro")
    @Mapping(target = "bairro.cidade.nome", source = "cidade")
    @Mapping(target = "bairro.cidade.estado.nome", source = "estado")
    @Mapping(target = "bairro.cidade.estado.pais.nome", source = "pais")
    @Mapping(target = "cliente", ignore = true)
    EnderecoEntrega from(PanacheEnderecoEntrega panacheEnderecoEntrega);

}
