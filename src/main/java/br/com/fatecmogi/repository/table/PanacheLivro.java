package br.com.fatecmogi.repository.table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Formula;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "livros")
@Getter
@Setter
public class PanacheLivro extends PanacheEntityBase {

	@Id
	@Column(name = "liv_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "liv_aut_id", referencedColumnName = "aut_id")
	private PanacheAutor autor;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "livros_categorias", joinColumns = @JoinColumn(name = "liv_id"),
			inverseJoinColumns = @JoinColumn(name = "ctl_id"))
	private Set<PanacheCategoria> categorias;

	@Column(name = "liv_ano_publicacao")
	private String anoPublicacao;

	@Column(name = "liv_titulo")
	private String titulo;

	@ManyToOne
	@JoinColumn(name = "liv_editora", referencedColumnName = "edt_id")
	private PanacheEditora editora;

	@Column(name = "liv_edicao")
	private Integer edicao;

	@Column(name = "liv_isbn")
	private String isbn;

	@Column(name = "liv_numero_paginas")
	private Integer numeroPaginas;

	@Column(name = "liv_sinopse")
	private String sinopse;

	@Column(name = "liv_altura")
	private BigDecimal altura;

	@Column(name = "liv_largura")
	private BigDecimal largura;

	@Column(name = "liv_peso")
	private BigDecimal peso;

	@Column(name = "liv_profundidade")
	private BigDecimal profundidade;

	@Column(name = "liv_codigo_barras")
	private String codigoBarras;

	@ManyToOne
	@JoinColumn(name = "liv_grp_id", referencedColumnName = "grp_id")
	private PanacheGrupoPrecificacao grupoPrecificacao;

	@Column(name = "liv_valor_venda")
	private BigDecimal valorVenda;

	@Column(name = "liv_valor_tabelado")
	private BigDecimal valorTabelado;

	@Column(name = "liv_ativo", columnDefinition = "BOOLEAN DEFAULT FALSE")
	private boolean ativo;

	@Column(name = "liv_capa")
	private String capa;

	@ManyToOne
	@JoinColumn(name = "liv_idioma", referencedColumnName = "idm_id")
	private PanacheIdioma idioma;

	@ManyToOne
	@JoinColumn(name = "liv_condicao", referencedColumnName = "cnd_id")
	private PanacheCondicao condicao;

	@Formula("(select (i.ite_quantidade) from itens_estoque i where i.liv_id = liv_id)")
	private Integer quantidade;

	public void unreferenceDependecies() {
		this.autor = null;
		this.categorias = null;
		this.editora = null;
		this.grupoPrecificacao = null;
		this.idioma = null;
		this.condicao = null;
	}

}
