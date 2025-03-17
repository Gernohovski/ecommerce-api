package br.com.fatecmogi.controller.mapper;

import br.com.fatecmogi.controller.dto.endereco.CadastrarEnderecoClienteCommand;
import br.com.fatecmogi.controller.dto.endereco.EditarEnderecoClienteCommand;
import br.com.fatecmogi.model.entity.endereco.EnderecoCobranca;
import br.com.fatecmogi.model.entity.endereco.EnderecoEntrega;
import br.com.fatecmogi.model.entity.endereco.EnderecoResidencial;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "cdi")
public interface EnderecoMapper {

	@Mapping(target = "bairro.nome", source = "bairro")
	@Mapping(target = "bairro.cidade.nome", source = "cidade")
	@Mapping(target = "bairro.cidade.estado.nome", source = "estado")
	@Mapping(target = "bairro.cidade.estado.pais.nome", source = "pais")
	@Mapping(target = "tipoResidencia.id", source = "tipoResidenciaId")
	@Mapping(target = "tipoLogradouro.id", source = "tipoLogradouroId")
	@Mapping(target = "cliente.id", source = "clienteId")
	EnderecoEntrega toEnderecoEntrega(CadastrarEnderecoClienteCommand command);

	@Mapping(target = "bairro.nome", source = "bairro")
	@Mapping(target = "bairro.cidade.nome", source = "cidade")
	@Mapping(target = "bairro.cidade.estado.nome", source = "estado")
	@Mapping(target = "bairro.cidade.estado.pais.nome", source = "pais")
	@Mapping(target = "tipoResidencia.id", source = "tipoResidenciaId")
	@Mapping(target = "tipoLogradouro.id", source = "tipoLogradouroId")
	@Mapping(target = "cliente.id", source = "clienteId")
	EnderecoCobranca toEnderecoCobranca(CadastrarEnderecoClienteCommand command);

	@Mapping(target = "bairro.nome", source = "bairro")
	@Mapping(target = "bairro.cidade.nome", source = "cidade")
	@Mapping(target = "bairro.cidade.estado.nome", source = "estado")
	@Mapping(target = "bairro.cidade.estado.pais.nome", source = "pais")
	@Mapping(target = "tipoResidencia.id", source = "tipoResidenciaId")
	@Mapping(target = "tipoLogradouro.id", source = "tipoLogradouroId")
	@Mapping(target = "cliente.id", source = "clienteId")
	EnderecoResidencial toEnderecoResidencial(CadastrarEnderecoClienteCommand command);

	@Mapping(target = "bairro.nome", source = "bairro")
	@Mapping(target = "bairro.cidade.nome", source = "cidade")
	@Mapping(target = "bairro.cidade.estado.nome", source = "estado")
	@Mapping(target = "bairro.cidade.estado.pais.nome", source = "pais")
	@Mapping(target = "tipoResidencia.id", source = "tipoResidenciaId")
	@Mapping(target = "tipoLogradouro.id", source = "tipoLogradouroId")
	@Mapping(target = "cliente.id", source = "clienteId")
	EnderecoResidencial updateEnderecoResidencial(@MappingTarget EnderecoResidencial enderecoResidencial,
			EditarEnderecoClienteCommand command);

	@Mapping(target = "bairro.nome", source = "bairro")
	@Mapping(target = "bairro.cidade.nome", source = "cidade")
	@Mapping(target = "bairro.cidade.estado.nome", source = "estado")
	@Mapping(target = "bairro.cidade.estado.pais.nome", source = "pais")
	@Mapping(target = "tipoResidencia.id", source = "tipoResidenciaId")
	@Mapping(target = "tipoLogradouro.id", source = "tipoLogradouroId")
	@Mapping(target = "cliente.id", source = "clienteId")
	EnderecoCobranca updateEnderecoCobranca(@MappingTarget EnderecoCobranca enderecoCobranca,
			EditarEnderecoClienteCommand command);

	@Mapping(target = "bairro.nome", source = "bairro")
	@Mapping(target = "bairro.cidade.nome", source = "cidade")
	@Mapping(target = "bairro.cidade.estado.nome", source = "estado")
	@Mapping(target = "bairro.cidade.estado.pais.nome", source = "pais")
	@Mapping(target = "tipoResidencia.id", source = "tipoResidenciaId")
	@Mapping(target = "tipoLogradouro.id", source = "tipoLogradouroId")
	@Mapping(target = "cliente.id", source = "clienteId")
	EnderecoEntrega updateEnderecoEntrega(@MappingTarget EnderecoEntrega enderecoEntrega,
			EditarEnderecoClienteCommand command);

}
