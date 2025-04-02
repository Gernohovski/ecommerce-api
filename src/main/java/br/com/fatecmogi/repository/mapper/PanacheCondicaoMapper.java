package br.com.fatecmogi.repository.mapper;

import br.com.fatecmogi.model.entity.livro.Condicao;
import br.com.fatecmogi.repository.table.PanacheCondicao;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface PanacheCondicaoMapper {

    List<Condicao> from(List<PanacheCondicao> panacheCondicao);

}
