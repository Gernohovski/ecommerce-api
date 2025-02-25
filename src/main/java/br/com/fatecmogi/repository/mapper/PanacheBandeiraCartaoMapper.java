package br.com.fatecmogi.repository.mapper;

import br.com.fatecmogi.model.entity.cartaoCredito.BandeiraCartao;
import br.com.fatecmogi.repository.table.PanacheBandeiraCartao;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface PanacheBandeiraCartaoMapper {

    List<BandeiraCartao> from(List<PanacheBandeiraCartao> panacheBandeiraCartao);

    BandeiraCartao from(PanacheBandeiraCartao panacheBandeiraCartao);

    PanacheBandeiraCartao from(BandeiraCartao bandeiraCartao);

}
