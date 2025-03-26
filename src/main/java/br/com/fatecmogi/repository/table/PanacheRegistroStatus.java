package br.com.fatecmogi.repository.table;

import br.com.fatecmogi.model.entity.livro.CategoriaStatusLivro;
import br.com.fatecmogi.model.entity.livro.Livro;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "registro_status_livro")
@Getter
@Setter
public class PanacheRegistroStatus {

	@Id
	@Column(name = "rsl_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "rsl_liv_id", referencedColumnName = "liv_id")
	private Livro livro;

	@Column(name = "rsl_justificativa")
	private String justificativa;

	@ManyToOne
	@JoinColumn(name = "rsl_cts_id", referencedColumnName = "cts_id")
	private CategoriaStatusLivro categoriaStatusLivro;

	@Column(name = "rsl_data_registro", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime dataRegistro;

}
