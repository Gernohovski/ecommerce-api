package br.com.fatecmogi.repository.mapper;

import br.com.fatecmogi.model.entity.livro.Editora;
import br.com.fatecmogi.repository.table.PanacheEditora;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface PanacheEditoraMapper {

	Editora from(PanacheEditora editora);

}
