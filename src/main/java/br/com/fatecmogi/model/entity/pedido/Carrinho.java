package br.com.fatecmogi.model.entity.pedido;

import br.com.fatecmogi.model.entity.cliente.Cliente;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection
public class Carrinho {

	private Long id;

	private List<ItemCarrinho> itens;

	@Builder.Default
	private LocalDateTime dataExpiracao = LocalDateTime.now().plusMinutes(30);

	private Cliente cliente;

}
