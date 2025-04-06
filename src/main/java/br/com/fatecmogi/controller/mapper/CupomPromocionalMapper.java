package br.com.fatecmogi.controller.mapper;

import br.com.fatecmogi.controller.dto.cupom.GerarCupomPromocionalCommand;
import br.com.fatecmogi.model.entity.cupom.CupomPromocional;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface CupomPromocionalMapper {

	CupomPromocional from(GerarCupomPromocionalCommand command);

}
