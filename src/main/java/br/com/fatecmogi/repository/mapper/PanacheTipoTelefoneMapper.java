package br.com.fatecmogi.repository.mapper;

import br.com.fatecmogi.model.entity.cliente.TipoTelefone;
import br.com.fatecmogi.repository.table.PanacheTipoTelefone;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface PanacheTipoTelefoneMapper {

	List<TipoTelefone> from(List<PanacheTipoTelefone> panacheTipoTelefone);

	TipoTelefone from(PanacheTipoTelefone panacheTipoTelefone);

}
