package br.com.fatecmogi.repository.table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "editoras")
@Getter
@Setter
public class PanacheEditora extends PanacheEntityBase {

	@Id
	@Column(name = "edt_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "edt_nome")
	private String nome;

}
