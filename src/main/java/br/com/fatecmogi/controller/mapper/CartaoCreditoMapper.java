package br.com.fatecmogi.controller.mapper;

import br.com.fatecmogi.controller.dto.cartaoCredito.CadastrarCartaoCreditoClienteCommand;
import br.com.fatecmogi.controller.dto.cartaoCredito.EditarCartaoCreditoClienteCommand;
import br.com.fatecmogi.model.entity.cartaoCredito.CartaoCredito;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "cdi")
public interface CartaoCreditoMapper {

    @Mapping(target = "bandeira.id", source = "bandeiraId")
    @Mapping(target = "cliente.id", source = "clienteId")
    CartaoCredito from(CadastrarCartaoCreditoClienteCommand command);

    @Mapping(target = "bandeira.id", source = "bandeiraId")
    @Mapping(target = "cliente.id", source = "clienteId")
    void update(@MappingTarget CartaoCredito cartaoCredito, EditarCartaoCreditoClienteCommand command);

}
