package br.com.fatecmogi.repository.mapper;

import br.com.fatecmogi.controller.mapper.EnderecoMapper;
import br.com.fatecmogi.model.entity.cartaoCredito.CartaoCredito;
import br.com.fatecmogi.repository.table.PanacheCartaoCredito;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "cdi", uses = {PanacheBandeiraCartaoMapper.class, EnderecoMapper.class, PanacheClienteMapper.class})
public interface PanacheCartaoCreditoMapper {

    @Mapping(target = "cliente", ignore = true)
    CartaoCredito from(PanacheCartaoCredito panacheCartaoCredito);

    @Mapping(target = "cliente", ignore = true)
    PanacheCartaoCredito from(CartaoCredito cartaoCredito);

    @Mapping(target = "cliente", ignore = true)
    PanacheCartaoCredito update(@MappingTarget PanacheCartaoCredito panacheCartaoCredito, CartaoCredito cartaoCredito);

    @Mapping(target = "cliente", ignore = true)
    List<CartaoCredito> from(List<PanacheCartaoCredito> panacheCartaoCreditos);
}
