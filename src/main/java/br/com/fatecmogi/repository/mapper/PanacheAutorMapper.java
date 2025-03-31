package br.com.fatecmogi.repository.mapper;

import br.com.fatecmogi.model.entity.livro.Autor;
import br.com.fatecmogi.repository.table.PanacheAutor;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface PanacheAutorMapper {

	Autor from(PanacheAutor panacheAutor);

	List<Autor> from(List<PanacheAutor> panacheAutor);

}
