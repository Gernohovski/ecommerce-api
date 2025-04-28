package br.com.fatecmogi.controller.mapper;

import br.com.fatecmogi.controller.dto.carrinho.CarrinhoDTO;
import br.com.fatecmogi.model.entity.pedido.Carrinho;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi", uses = { ItemCarrinhoMapper.class })
public interface CarrinhoMapper {

	CarrinhoDTO from(Carrinho carrinho);

	Carrinho to(Carrinho carrinho);

}
