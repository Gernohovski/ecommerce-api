package br.com.fatecmogi.repository.mapper;

import br.com.fatecmogi.model.entity.cupom.CupomTroca;
import br.com.fatecmogi.repository.table.PanacheCupomTroca;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "cdi", uses = { PanacheClienteMapper.class })
public interface PanacheCupomTrocaMapper {

	PanacheCupomTroca from(CupomTroca cupomTroca);

	CupomTroca from(PanacheCupomTroca panacheCupomTroca);

	PanacheCupomTroca update(@MappingTarget PanacheCupomTroca panacheCupomTroca, CupomTroca cupomTroca);

	List<CupomTroca> from(List<PanacheCupomTroca> panacheCupomTroca);

}
