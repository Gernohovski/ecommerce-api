package br.com.fatecmogi.repository.table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "grupos_precificacao")
@Getter
@Setter
public class PanacheGrupoPrecificacao extends PanacheEntityBase {

	@Id
	@Column(name = "grp_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "grp_nome")
	private String nome;

	@Column(name = "grp_margem_lucro")
	private BigDecimal margemLucro;

}
