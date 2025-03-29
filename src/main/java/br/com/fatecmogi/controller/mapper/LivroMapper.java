package br.com.fatecmogi.controller.mapper;

import br.com.fatecmogi.controller.dto.livro.EditarLivroCommand;
import br.com.fatecmogi.model.entity.livro.Categoria;
import br.com.fatecmogi.model.entity.livro.Livro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "cdi")
public interface LivroMapper {

    @Mapping(target = "ativo", ignore = true)
    @Mapping(target = "autor.id", source = "autorId")
    @Mapping(target = "categorias", source = "categoriasId", qualifiedByName = "mapCategorias")
    @Mapping(target = "editora.id", source = "editoraId")
    @Mapping(target = "grupoPrecificacao.id", source = "grupoPrecificacaoId")
    Livro update(@MappingTarget Livro livro, EditarLivroCommand command);

    @Named("mapCategorias")
    default Set<Categoria> mapCategorias(Set<Long> categoriasId) {
        if (categoriasId == null) {
            return Collections.emptySet();
        }
        return categoriasId.stream()
                .map(id -> {
                    Categoria categoria = new Categoria();
                    categoria.setId(id);
                    return categoria;
                })
                .collect(Collectors.toSet());
    }
}
