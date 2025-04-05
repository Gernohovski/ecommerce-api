package br.com.fatecmogi.repository.mapper;

import br.com.fatecmogi.model.entity.livro.Idioma;
import br.com.fatecmogi.repository.table.PanacheIdioma;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface PanacheIdiomaMapper {

	List<Idioma> from(List<PanacheIdioma> panacheIdioma);

}
