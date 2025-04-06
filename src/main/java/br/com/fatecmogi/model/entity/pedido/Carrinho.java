package br.com.fatecmogi.model.entity.pedido;

import br.com.fatecmogi.model.entity.cliente.Cliente;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection
public class Carrinho {

	private Long id;

	@Builder.Default
	private List<ItemCarrinho> itens = new ArrayList<>();

	@Builder.Default
	private LocalDateTime dataExpiracao = LocalDateTime.now().plusMinutes(30);

	@Builder.Default
	private LocalDateTime dataCriacao = LocalDateTime.now();

	@Builder.Default
	private boolean comprado = false;

	private Cliente cliente;

	public void atualizar() {
		this.dataExpiracao = LocalDateTime.now().plusMinutes(30);
	}

	public void addItem(ItemCarrinho item) {
		this.itens.add(item);
	}

	public void removeItem(Long id) {
		this.itens.removeIf(item -> item.getId().equals(id));
	}

}
