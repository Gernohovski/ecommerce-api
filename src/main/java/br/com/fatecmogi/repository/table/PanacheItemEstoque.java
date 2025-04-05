package br.com.fatecmogi.repository.table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "itens_estoque")
@Getter
@Setter
public class PanacheItemEstoque extends PanacheEntityBase {

	@Id
	@Column(name = "ite_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "est_id")
	private PanacheEstoque estoque;

	@ManyToOne
	@JoinColumn(name = "liv_id")
	private PanacheLivro livro;

	@Column(name = "ite_quantidade")
	private Integer quantidade;

}
