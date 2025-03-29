package br.com.fatecmogi.repository.mapper;

import br.com.fatecmogi.model.entity.livro.Categoria;
import br.com.fatecmogi.repository.table.PanacheCategoria;
import br.com.fatecmogi.repository.table.PanacheLivro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper(componentModel = "cdi")
public interface PanacheCategoriaMapper {

	@Mapping(target = "livros", ignore = true)
	Categoria from(PanacheCategoria panacheCategoria);

	@Mapping(target = "livros", ignore = true)
	Set<Categoria> from(Set<PanacheLivro> panacheLivro);

}
