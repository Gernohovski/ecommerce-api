package br.com.fatecmogi.repository.mapper;

import br.com.fatecmogi.model.entity.cliente.Cliente;
import br.com.fatecmogi.repository.table.PanacheCartaoCredito;
import br.com.fatecmogi.repository.table.PanacheCliente;
import br.com.fatecmogi.service.ClienteService;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "cdi", uses = {PanacheTelefoneMapper.class, PanacheEnderecoMapper.class, PanacheCartaoCreditoMapper.class})
public interface PanacheClienteMapper {

    Cliente from(PanacheCliente cliente);

    PanacheCliente from(Cliente cliente);

    PanacheCliente update(@MappingTarget PanacheCliente panacheCliente, Cliente cliente);

    List<Cliente> from(List<PanacheCliente> panacheCliente);
}
