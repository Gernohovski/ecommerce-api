package br.com.fatecmogi.repository.mapper;

import br.com.fatecmogi.model.entity.livro.Autor;
import br.com.fatecmogi.repository.table.PanacheAutor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface PanacheAutorMapper {

	Autor from(PanacheAutor panacheAutor);

}
