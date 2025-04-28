package br.com.fatecmogi.repository.table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "cupons_troca")
@Getter
@Setter
public class PanacheCupomTroca extends PanacheEntityBase {

	@Id
	@Column(name = "cpt_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "cpt_valor_desconto")
	private BigDecimal valorDesconto;

	@Column(name = "cpt_codigo")
	private String codigo;

	@Column(name = "cpt_utilizado")
	private boolean utilizado;

	@ManyToOne
	@JoinColumn(name = "cpt_clt_id", referencedColumnName = "clt_id")
	private PanacheCliente cliente;

}
