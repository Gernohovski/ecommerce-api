package br.com.fatecmogi.repository.table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "solicitacoes_troca")
@Getter
@Setter
public class PanacheSolicitacaoTroca extends PanacheEntityBase {

	@Id
	@Column(name = "stc_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToMany
	@JoinTable(name = "itens_pedido_solicitacao_troca", joinColumns = @JoinColumn(name = "stc_id"),
			inverseJoinColumns = @JoinColumn(name = "itp_id"))
	private Set<PanacheItemPedido> itensPedido;

	@ManyToOne
	@JoinColumn(name = "ped_id")
	private PanachePedido pedido;

}
