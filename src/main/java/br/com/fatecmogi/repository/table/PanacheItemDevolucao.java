package br.com.fatecmogi.repository.table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "itens_devolucao")
@Getter
@Setter
public class PanacheItemDevolucao extends PanacheEntityBase {

	@Id
	@Column(name = "itd_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "itd_quantidade")
	private int quantidade;

	@ManyToOne
	@JoinColumn(name = "itp_id")
	private PanacheItemPedido itemPedido;

}