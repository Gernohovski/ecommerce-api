package br.com.fatecmogi.repository.table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "itens_carrinho")
@Getter
@Setter
public class PanacheItemCarrinho extends PanacheEntityBase {

	@Id
	@Column(name = "itc_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "car_id")
	private PanacheCarrinho carrinho;

	@ManyToOne
	@JoinColumn(name = "liv_id")
	private PanacheLivro livro;

	@Column(name = "itc_quantidade")
	private Integer quantidade;

}
