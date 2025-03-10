package br.com.fatecmogi.controller.mapper;

import br.com.fatecmogi.controller.dto.cliente.CadastrarClienteCommand;
import br.com.fatecmogi.controller.dto.cliente.EditarClienteCommand;
import br.com.fatecmogi.controller.dto.cliente.EditarSenhaClienteCommand;
import br.com.fatecmogi.model.entity.cliente.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "cdi", uses = {EnderecoMapper.class, CartaoCreditoMapper.class})
public interface ClienteMapper {

    @Mapping(target = "genero.id", source = "generoId")
    @Mapping(target = "telefone.ddd", source = "ddd")
    @Mapping(target = "telefone.telefone", source = "telefone")
    @Mapping(target = "telefone.tipoTelefone.id", source = "tipoTelefoneId")
    @Mapping(target = "ativo", ignore = true)
    Cliente from(CadastrarClienteCommand command);

    @Mapping(target = "enderecoResidencial", ignore = true)
    @Mapping(target = "enderecoCobranca", ignore = true)
    @Mapping(target = "enderecoEntrega", ignore = true)
    @Mapping(target = "cartaoCredito", ignore = true)
    @Mapping(target = "ativo", ignore = true)
    @Mapping(target = "telefone.ddd", source = "ddd")
    @Mapping(target = "telefone.telefone", source = "telefone")
    @Mapping(target = "telefone.tipoTelefone.id", source = "tipoTelefoneId")
    @Mapping(target = "genero.id", source = "generoId")
    Cliente update(@MappingTarget Cliente cliente, EditarClienteCommand command);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "genero", ignore = true)
    @Mapping(target = "enderecoResidencial", ignore = true)
    @Mapping(target = "enderecoCobranca", ignore = true)
    @Mapping(target = "enderecoEntrega", ignore = true)
    @Mapping(target = "cartaoCredito", ignore = true)
    @Mapping(target = "ativo", ignore = true)
    @Mapping(target = "cpf", ignore = true)
    @Mapping(target = "email", ignore = true)
    @Mapping(target = "telefone", ignore = true)
    @Mapping(target = "dataNascimento", ignore = true)
    Cliente update(@MappingTarget Cliente cliente, EditarSenhaClienteCommand command);

}
