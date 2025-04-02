package br.com.fatecmogi.repository.table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "categorias_livros")
@Getter
@Setter
public class PanacheCategoria extends PanacheEntityBase {

	@Id
	@Column(name = "ctl_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "ctl_nome")
	private String nome;

	@ManyToMany(mappedBy = "categorias", fetch = FetchType.LAZY)
	private Set<PanacheLivro> livros;
}
