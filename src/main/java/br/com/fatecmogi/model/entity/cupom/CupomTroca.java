package br.com.fatecmogi.model.entity.cupom;

import br.com.fatecmogi.model.entity.cliente.Cliente;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.apache.commons.lang3.RandomStringUtils;

import java.math.BigDecimal;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@RegisterForReflection
public class CupomTroca extends Cupom {

	private BigDecimal valorDesconto;

	private Cliente cliente;

	@Builder.Default
	private boolean utilizado = false;

	public void gerarCodigo() {
		var codigo = RandomStringUtils.random(5, true, true);
		this.setCodigo(codigo.toUpperCase());
	}

}
