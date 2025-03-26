package br.com.fatecmogi.repository.table;

import br.com.fatecmogi.model.entity.livro.Autor;
import br.com.fatecmogi.model.entity.livro.Categoria;
import br.com.fatecmogi.model.entity.livro.Editora;
import br.com.fatecmogi.model.entity.livro.GrupoPrecificacao;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
	private Autor autor;

	@ManyToMany
	@JoinTable(name = "livros_categorias", joinColumns = @JoinColumn(name = "liv_id"),
			inverseJoinColumns = @JoinColumn(name = "ctl_id"))
	private Set<Categoria> categorias;

	@Column(name = "liv_ano_publicacao")
	private String anoPublicacao;

	@Column(name = "liv_titulo")
	private String titulo;

	@Column(name = "liv_editora")
	private Editora editora;

	@Column(name = "liv_edicao")
	private Integer edicao;

	@Column(name = "liv_isbn")
	private String ISBN;

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
	private GrupoPrecificacao grupoPrecificacao;

	@Column(name = "liv_valor_venda")
	private BigDecimal valorVenda;

	@Column(name = "liv_ativo", columnDefinition = "BOOLEAN DEFAULT FALSE")
	private boolean ativo;

}
