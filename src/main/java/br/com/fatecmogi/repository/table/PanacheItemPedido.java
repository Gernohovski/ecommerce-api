package br.com.fatecmogi.repository.table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Formula;

import java.math.BigDecimal;

@Entity
@Table(name = "itens_pedido")
@Getter
@Setter
public class PanacheItemPedido extends PanacheEntityBase {

	@Id
	@Column(name = "itp_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "car_id")
	private PanacheCarrinho carrinho;

	@ManyToOne
	@JoinColumn(name = "liv_id")
	private PanacheLivro livro;

	@Column(name = "itp_quantidade")
	private Integer quantidade;

	@Column(name = "itp_valor")
	private BigDecimal valor;

	@ManyToOne
	@JoinColumn(name = "ped_id")
	private PanachePedido pedido;

	@Formula("(select case when count(st.stc_id) > 0 then true else false end "
			+ "from itens_pedido_solicitacao_troca st " + "where st.itp_id = itp_id)")
	private boolean trocaAberta;

	@Formula("(select case when count(st.std_id) > 0 then true else false end "
			+ "from itens_pedido_solicitacao_devolucao st " + "where st.itp_id = itp_id)")
	private boolean devolucaoAberta;

}
