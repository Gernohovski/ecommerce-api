package br.com.fatecmogi.model.entity.livro;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection
public class GrupoPrecificacao {

	private Long id;

	private String nome;

	private BigDecimal margemLucro;

}
