package br.com.fatecmogi.model.entity.livro;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.Set;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection
public class Livro {

	private Autor autor;

	private Set<Categoria> categorias;

	private String anoPublicacao;

	private String titulo;

	private Editora editora;

	private Integer edicao;

	private String ISBN;

	private Integer numeroPaginas;

	private String sinopse;

	private BigDecimal altura;

	private BigDecimal largura;

	private BigDecimal peso;

	private BigDecimal profundidade;

	private String codigoBarras;

	private GrupoPrecificacao grupoPrecificacao;

	private BigDecimal valorVenda;

	@Builder.Default
	private boolean ativo = false;

}
