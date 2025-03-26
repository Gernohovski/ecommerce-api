package br.com.fatecmogi.repository.table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "autores")
@Getter
@Setter
public class PanacheAutor extends PanacheEntityBase {

	@Id
	@Column(name = "aut_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "aut_nome")
	private String nome;

}
