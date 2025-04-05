package br.com.fatecmogi.repository.table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "situacoes_pedido")
@Getter
@Setter
public class PanacheSituacaoPedido extends PanacheEntityBase {

	@Id
	@Column(name = "stp_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "stp_nome")
	private String nome;

}
