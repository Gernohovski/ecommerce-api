package br.com.fatecmogi.repository.table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "itens_troca")
@Getter
@Setter
public class PanacheItemTroca extends PanacheEntityBase {

	@Id
	@Column(name = "ita_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "ita_quantidade")
	private int quantidade;

	@ManyToOne
	@JoinColumn(name = "itp_id")
	private PanacheItemPedido itemPedido;

}
