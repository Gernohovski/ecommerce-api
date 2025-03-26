package br.com.fatecmogi.model.entity.livro;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection
public class RegistroStatus {

	private Livro livro;

	private String justificativa;

	private CategoriaStatusLivro categoriaStatusLivro;

	@Builder.Default
	private LocalDateTime dataRegistro = LocalDateTime.now();

}
