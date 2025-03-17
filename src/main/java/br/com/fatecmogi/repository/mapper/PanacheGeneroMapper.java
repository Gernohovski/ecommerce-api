package br.com.fatecmogi.repository.mapper;

import br.com.fatecmogi.model.entity.cliente.Genero;
import br.com.fatecmogi.repository.table.PanacheGenero;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface PanacheGeneroMapper {

	List<Genero> from(List<PanacheGenero> panacheGenero);

	Genero from(PanacheGenero genero);

}
