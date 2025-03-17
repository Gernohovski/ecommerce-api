package br.com.fatecmogi.model.entity.cliente;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection
public class Telefone {

	private Long id;

	private String ddd;

	private String telefone;

	private TipoTelefone tipoTelefone;

}
