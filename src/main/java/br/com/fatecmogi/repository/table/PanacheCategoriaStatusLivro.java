package br.com.fatecmogi.repository.table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "categorias_status")
@Getter
@Setter
public class PanacheCategoriaStatusLivro extends PanacheEntityBase {

	@Id
	@Column(name = "cts_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "cts_nome")
	private String nome;

}
