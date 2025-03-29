package br.com.fatecmogi.repository.mapper;

import br.com.fatecmogi.model.entity.livro.GrupoPrecificacao;
import br.com.fatecmogi.repository.table.PanacheGrupoPrecificacao;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface PanacheGrupoPrecificacaoMapper {

	GrupoPrecificacao from(PanacheGrupoPrecificacao panacheGrupoPrecificacao);

}
