package br.com.fatecmogi.repository.mapper;

import br.com.fatecmogi.model.entity.cupom.CupomPromocional;
import br.com.fatecmogi.repository.table.PanacheCupomPromocional;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface PanacheCupomPromocionalMapper {

	PanacheCupomPromocional from(CupomPromocional cupomPromocional);

	CupomPromocional from(PanacheCupomPromocional panacheCupomPromocional);

}
