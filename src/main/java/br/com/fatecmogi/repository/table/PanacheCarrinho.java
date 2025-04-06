package br.com.fatecmogi.repository.table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "carrinhos")
@Getter
@Setter
public class PanacheCarrinho extends PanacheEntityBase {

	@Id
	@Column(name = "car_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(mappedBy = "carrinho", cascade = CascadeType.MERGE, orphanRemoval = true)
	private List<PanacheItemCarrinho> itens;

	@Column(name = "car_data_expiracao")
	private LocalDateTime dataExpiracao;

	@Column(name = "car_data_criacao")
	private LocalDateTime dataCriacao;

	@Column(name = "car_comprado")
	private boolean comprado;

	@ManyToOne
	@JoinColumn(name = "clt_id")
	private PanacheCliente cliente;

	public void persistDependecies() {
		for (PanacheItemCarrinho item : this.itens) {
			if (item.getId() == null) {
				PanacheItemCarrinho.persist(item);
			}
		}
	}

}
