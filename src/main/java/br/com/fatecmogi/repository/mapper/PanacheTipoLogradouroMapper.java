package br.com.fatecmogi.repository.mapper;

import br.com.fatecmogi.model.entity.endereco.TipoLogradouro;
import br.com.fatecmogi.repository.table.PanacheTipoLogradouro;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface PanacheTipoLogradouroMapper {

    List<TipoLogradouro> from(List<PanacheTipoLogradouro> panacheTipoLogradouro);

    TipoLogradouro from(PanacheTipoLogradouro panacheTipoLogradouro);

}
