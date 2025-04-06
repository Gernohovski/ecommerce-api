package br.com.fatecmogi.repository.mapper;

import br.com.fatecmogi.model.entity.pedido.Carrinho;
import br.com.fatecmogi.model.entity.pedido.ItemCarrinho;
import br.com.fatecmogi.repository.table.PanacheCarrinho;
import br.com.fatecmogi.repository.table.PanacheItemCarrinho;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "cdi", uses = {PanacheClienteMapper.class, PanacheLivroMapper.class})
public interface PanacheItemCarrinhoMapper {

    @Mapping(target = "carrinho", ignore = true)
    List<ItemCarrinho> from(List<PanacheItemCarrinho> panacheItemCarrinho);

    @Mapping(target = "carrinho", ignore = true)
    ItemCarrinho from(PanacheItemCarrinho itemCarrinho);

    @Mapping(target = "carrinho", ignore = true)
    PanacheItemCarrinho from(ItemCarrinho itemCarrinho);

    @Mapping(target = "carrinho", ignore = true)
    PanacheItemCarrinho update(@MappingTarget PanacheItemCarrinho panacheItemCarrinho, ItemCarrinho itemCarrinho);

}
