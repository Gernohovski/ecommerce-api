package br.com.fatecmogi.repository.mapper;

import br.com.fatecmogi.controller.dto.livro.CategoriaLivroDTO;
import br.com.fatecmogi.repository.table.PanacheCategoria;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface PanacheCategoriasLivrosMapper {

	@Mapping(target = "livros", ignore = true)
	List<CategoriaLivroDTO> from(List<PanacheCategoria> panacheCategorias);

}
