package br.com.fatecmogi.repository.mapper;

import br.com.fatecmogi.model.entity.pedido.Carrinho;
import br.com.fatecmogi.repository.table.PanacheCarrinho;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "cdi", uses = {PanacheClienteMapper.class, PanacheItemCarrinhoMapper.class})
public interface PanacheCarrinhoMapper {

    List<Carrinho> from(List<PanacheCarrinho> panacheCarrinho);

    PanacheCarrinho from(Carrinho carrinho);

    Carrinho from(PanacheCarrinho panacheCarrinho);

    PanacheCarrinho update(@MappingTarget PanacheCarrinho panacheCarrinho, Carrinho carrinho);

}
