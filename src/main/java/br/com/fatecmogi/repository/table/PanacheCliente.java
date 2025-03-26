package br.com.fatecmogi.repository.table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "clientes")
@Getter
@Setter
public class PanacheCliente extends PanacheEntityBase {

	@Id
	@Column(name = "clt_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "clt_gen_id", referencedColumnName = "gen_id")
	private PanacheGenero genero;

	@Column(name = "clt_nome")
	private String nome;

	@Column(name = "clt_termo_pesquisa")
	private String termoPesquisa;

	@Column(name = "clt_data_nascimento")
	private LocalDate dataNascimento;

	@Column(name = "clt_cpf")
	private String cpf;

	@Column(name = "clt_email")
	private String email;

	@Column(name = "clt_senha")
	private String senha;

	@Column(name = "clt_ativo")
	private boolean ativo;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "clt_tlf_id", referencedColumnName = "tlf_id")
	private PanacheTelefone telefone;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.MERGE)
	private List<PanacheEnderecoResidencial> enderecoResidencial;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.MERGE)
	private List<PanacheEnderecoCobranca> enderecoCobranca;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.MERGE)
	private List<PanacheEnderecoEntrega> enderecoEntrega;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.MERGE)
	private List<PanacheCartaoCredito> cartaoCredito;

	public void persistDependecies() {
		for (PanacheEnderecoResidencial endereco : this.enderecoResidencial) {
			if (endereco.getId() == null) {
				PanacheEnderecoResidencial.persist(this.enderecoResidencial);
			}
		}
		for (PanacheEnderecoCobranca endereco : this.enderecoCobranca) {
			if (endereco.getId() == null) {
				PanacheEnderecoCobranca.persist(this.enderecoCobranca);
			}
		}
		for (PanacheEnderecoEntrega endereco : this.enderecoEntrega) {
			if (endereco.getId() == null) {
				PanacheEnderecoEntrega.persist(this.enderecoEntrega);
			}
		}
		for (PanacheCartaoCredito cartao : this.cartaoCredito) {
			if (cartao.getId() == null) {
				PanacheCartaoCredito.persist(this.cartaoCredito);
			}
		}
		if (this.telefone.getId() == null) {
			PanacheTelefone.persist(this.telefone);
		}
	}

	public void unreferrenceDependecies() {
		this.genero = null;
	}

	public void deleteDependecies() {
		this.enderecoResidencial.forEach(PanacheEnderecoResidencial::delete);
		this.enderecoCobranca.forEach(PanacheEnderecoCobranca::delete);
		this.enderecoEntrega.forEach(PanacheEnderecoEntrega::delete);
		this.cartaoCredito.forEach(PanacheCartaoCredito::delete);
		this.telefone.delete();
		this.genero = null;
	}

}
