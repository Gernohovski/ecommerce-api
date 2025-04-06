package br.com.fatecmogi.controller.mapper;

import br.com.fatecmogi.controller.dto.carrinho.AdicionarItemCarrinhoCommand;
import br.com.fatecmogi.model.entity.pedido.ItemCarrinho;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface ItemCarrinhoMapper {

    @Mapping(target = "livro.id", source = "livroId")
    @Mapping(target = "carrinho", ignore = true)
    ItemCarrinho from(AdicionarItemCarrinhoCommand command);

}
