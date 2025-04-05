package br.com.fatecmogi.repository.mapper;

import br.com.fatecmogi.model.entity.livro.Livro;
import br.com.fatecmogi.repository.table.PanacheLivro;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "cdi", uses = { PanacheAutorMapper.class, PanacheCategoriaMapper.class,
		PanacheEditoraMapper.class, PanacheGrupoPrecificacaoMapper.class })
public interface PanacheLivroMapper {

	List<Livro> from(List<PanacheLivro> panacheLivro);

	PanacheLivro update(@MappingTarget PanacheLivro panacheLivro, Livro livro);

	Livro from(PanacheLivro panacheLivro);

}
