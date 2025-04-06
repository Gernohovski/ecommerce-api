package br.com.fatecmogi.model.entity.cupom;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@RegisterForReflection
public class Cupom {

	private Long id;

	private Double porcentagemDesconto;

	@Builder.Default
	private LocalDateTime dataExpiracao = LocalDateTime.now().plusMinutes(30);

	private String codigo;

}
