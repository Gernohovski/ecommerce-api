package br.com.fatecmogi.repository.table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pedidos")
@Getter
@Setter
public class PanachePedido extends PanacheEntityBase {

	@Id
	@Column(name = "ped_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "stp_id")
	private PanacheSituacaoPedido situacaoPedido;

	@ManyToOne
	@JoinColumn(name = "car_id")
	private PanacheCarrinho carrinho;

	@OneToMany(mappedBy = "pedido", cascade = CascadeType.MERGE, orphanRemoval = true)
	private List<PanacheItemPedido> itensPedido;

	@Column(name = "ped_data_pedido")
	private LocalDate dataPedido;

	@Column(name = "ped_data_alteracao")
	private LocalDateTime dataAlteracao;

	@Column(name = "ped_valor_pedido")
	private BigDecimal valorPedido;

	@Column(name = "ped_valor_frete")
	private BigDecimal valorFrete;

	@ManyToOne
	@JoinColumn(name = "eet_id")
	private PanacheEnderecoEntrega endereco;

	@ManyToMany
	@JoinTable(name = "pedido_cartao", joinColumns = @JoinColumn(name = "ped_id"),
			inverseJoinColumns = @JoinColumn(name = "crc_id"))
	private List<PanacheCartaoCredito> cartoesCredito;

	@ManyToOne
	@JoinColumn(name = "clt_id")
	private PanacheCliente cliente;

	public void persistDependecies() {
		if (!this.itensPedido.isEmpty()) {
			this.itensPedido.forEach(item -> {
				item.setCarrinho(this.carrinho);
				item.setPedido(this);
				item.persist();
			});
		}
	}

}
