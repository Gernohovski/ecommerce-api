package br.com.fatecmogi.repository.mapper;

import br.com.fatecmogi.model.entity.endereco.TipoResidencia;
import br.com.fatecmogi.repository.table.PanacheTipoResidencia;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface PanacheTipoResidenciaMapper {

    List<TipoResidencia> from(List<PanacheTipoResidencia> panacheTipoResidencia);

    TipoResidencia from(PanacheTipoResidencia panacheTipoResidencia);

}
