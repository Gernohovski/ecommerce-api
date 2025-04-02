package br.com.fatecmogi.model.entity.livro;

import br.com.fatecmogi.model.exception.livro.LivroValorInsuficienteException;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.File;
import java.math.BigDecimal;
import java.util.Set;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection
public class Livro {

	private Long id;

	private Autor autor;

	private Set<Categoria> categorias;

	private String anoPublicacao;

	private String titulo;

	private Editora editora;

	private Integer edicao;

	private String isbn;

	private Integer numeroPaginas;

	private String sinopse;

	private BigDecimal altura;

	private BigDecimal largura;

	private BigDecimal peso;

	private BigDecimal profundidade;

	private String codigoBarras;

	private GrupoPrecificacao grupoPrecificacao;

	private BigDecimal valorTabelado;

	private BigDecimal valorVenda;

	@Builder.Default
	private boolean ativo = false;

	private String capa;

	private Idioma idioma;

	private Condicao condicao;

	public void validarValorVenda() {
		var valorMinimo = this.valorTabelado
				.multiply(this.grupoPrecificacao.getMargemLucro().divide(BigDecimal.valueOf(100)).add(BigDecimal.ONE));
		if (valorVenda.compareTo(valorMinimo) < 0) {
			throw new LivroValorInsuficienteException();
		}
	}


}
