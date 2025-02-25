package br.com.fatecmogi.repository.mapper;

import br.com.fatecmogi.model.entity.cliente.Telefone;
import br.com.fatecmogi.repository.table.PanacheTelefone;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = "cdi")
public interface PanacheTelefoneMapper {

    Telefone from(PanacheTelefone panacheTelefone);

    PanacheTelefone from(Telefone telefone);

}
