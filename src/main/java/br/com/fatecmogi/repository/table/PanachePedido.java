package br.com.fatecmogi.repository.table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
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

	@Column(name = "ped_data_pedido")
	private LocalDate dataPedido;

	@Column(name = "ped_valor_pedido")
	private BigDecimal valorPedido;

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

}
