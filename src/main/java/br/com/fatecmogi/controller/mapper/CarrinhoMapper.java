package br.com.fatecmogi.controller.mapper;

import br.com.fatecmogi.controller.dto.carrinho.CarrinhoDTO;
import br.com.fatecmogi.model.entity.pedido.Carrinho;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface CarrinhoMapper {

	CarrinhoDTO from(Carrinho carrinho);

}
