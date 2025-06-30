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

	@Formula("(SELECT CASE WHEN EXISTS (SELECT 1 FROM itens_troca it "
			+ "JOIN itens_troca_solicitacao_troca itst ON it.ita_id = itst.ita_id "
			+ "JOIN solicitacoes_troca st ON itst.stc_id = st.stc_id " + "WHERE it.itp_id = itp_id) THEN 1 ELSE 0 END)")
	private boolean trocaAberta;

	@Formula("(SELECT CASE WHEN EXISTS (SELECT 1 FROM itens_devolucao it "
			+ "JOIN itens_devolucao_solicitacao_devolucao itst ON it.itd_id = itst.itd_id "
			+ "JOIN solicitacoes_devolucao st ON itst.std_id = st.std_id "
			+ "WHERE it.itp_id = itp_id) THEN 1 ELSE 0 END)")
	private boolean devolucaoAberta;

	@Formula("(SELECT it.ita_quantidade " + "FROM itens_troca it " + "WHERE it.itp_id = itp_id)")
	private Integer quantidadeTroca;

	@Formula("(SELECT it.itd_quantidade " + "FROM itens_devolucao it " + "WHERE it.itp_id = itp_id)")
	private Integer quantidadeDevolucao;

}
