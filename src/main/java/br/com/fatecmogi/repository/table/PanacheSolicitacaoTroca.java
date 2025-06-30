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

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinTable(name = "itens_troca_solicitacao_troca", joinColumns = @JoinColumn(name = "stc_id"),
			inverseJoinColumns = @JoinColumn(name = "ita_id"))
	private Set<PanacheItemTroca> item;

	@ManyToOne
	@JoinColumn(name = "ped_id")
	private PanachePedido pedido;

	public void persistDependencies() {
		for (PanacheItemTroca itemTroca : this.item) {
			if (itemTroca.getId() == null) {
				itemTroca.persistAndFlush();
			}
		}
		PanacheItemTroca.flush();
	}

}
