package br.com.fatecmogi.repository.table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "solicitacoes_devolucao")
@Getter
@Setter
public class PanacheSolicitacaoDevolucao extends PanacheEntityBase {

	@Id
	@Column(name = "std_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "itens_devolucao_solicitacao_devolucao", joinColumns = @JoinColumn(name = "std_id"),
			inverseJoinColumns = @JoinColumn(name = "itd_id"))
	private Set<PanacheItemDevolucao> item;

	@ManyToOne
	@JoinColumn(name = "ped_id")
	private PanachePedido pedido;

	public void persistDependencies() {
		for (PanacheItemDevolucao itemDevolucao : this.item) {
			if (itemDevolucao.getId() == null) {
				PanacheItemDevolucao.persist(this.item);
			}
		}
	}

}
