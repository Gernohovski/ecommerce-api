package br.com.fatecmogi.repository.mapper;

import br.com.fatecmogi.model.entity.estoque.ItemEstoque;
import br.com.fatecmogi.repository.table.PanacheItemEstoque;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "cdi", uses = { PanacheLivroMapper.class })
public interface PanacheItemEstoqueMapper {

	@Mapping(target = "estoque", ignore = true)
	@Mapping(target = "livro", ignore = true)
	PanacheItemEstoque update(@MappingTarget PanacheItemEstoque panacheItemEstoque, ItemEstoque itemEstoque);

	ItemEstoque from(PanacheItemEstoque panacheItemEstoque);

}
