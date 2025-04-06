package br.com.fatecmogi.repository.table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "cupons_promocionais")
@Getter
@Setter
public class PanacheCupomPromocional extends PanacheEntityBase {

	@Id
	@Column(name = "cpp_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "cpp_porcentagem_desconto")
	private Double porcentagemDesconto;

	@Column(name = "cpp_data_expiracao")
	private LocalDateTime dataExpiracao;

	@Column(name = "cpp_codigo")
	private String codigo;

}
