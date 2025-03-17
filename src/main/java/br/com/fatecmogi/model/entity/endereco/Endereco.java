package br.com.fatecmogi.model.entity.endereco;

import br.com.fatecmogi.model.entity.cliente.Cliente;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection
public class Endereco {

	private Long id;

	private TipoResidencia tipoResidencia;

	private TipoLogradouro tipoLogradouro;

	private String logradouro;

	private String numero;

	private Bairro bairro;

	private String cep;

	private String observacoes;

	private String fraseIdentificacao;

	@Builder.Default
	private boolean principal = false;

	private Cliente cliente;

}
