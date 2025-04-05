package br.com.fatecmogi.model.entity.estoque;

import br.com.fatecmogi.model.entity.livro.Livro;
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
public class ItemEstoque {

	private Long id;

	private Livro livro;

	private int quantidade;

}
