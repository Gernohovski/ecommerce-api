package br.com.fatecmogi.repository.table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "estoques")
@Getter
@Setter
public class PanacheEstoque extends PanacheEntityBase {

	@Id
	@Column(name = "est_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(mappedBy = "estoque", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PanacheItemEstoque> itens;

}
