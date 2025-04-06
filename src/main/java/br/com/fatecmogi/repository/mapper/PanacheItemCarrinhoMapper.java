package br.com.fatecmogi.repository.mapper;

import br.com.fatecmogi.model.entity.pedido.ItemCarrinho;
import br.com.fatecmogi.repository.table.PanacheItemCarrinho;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "cdi", uses = { PanacheClienteMapper.class, PanacheLivroMapper.class })
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
