package br.com.fatecmogi.controller.dto.livro;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.Set;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class EditarLivroCommand {

	@NotNull(message = "O autor do livro é obrigatório.")
	private Long autorId;

	@NotNull(message = "Informe ao menos uma categoria para o livro.")
	private Set<Long> categoriasId;

	@NotBlank(message = "O ano da publicação do livro é obrigatória.")
	private String anoPublicacao;

	@NotBlank(message = "O título do livro é obrigatório.")
	private String titulo;

	@NotNull(message = "A editora do livro é obrigatória.")
	private Long editoraId;

	@NotNull(message = "A edição do livro é obrigatória.")
	private Integer edicao;

	@NotBlank(message = "O ISBN do livro é obrigatório.")
	private String isbn;

	@NotNull(message = "O número de páginas do livro é obrigatório.")
	private Integer numeroPaginas;

	@NotBlank(message = "A sinopse do livro é obrigatória.")
	private String sinopse;

	@NotNull(message = "A altura do livro é obrigatória.")
	private BigDecimal altura;

	@NotNull(message = "A largura do livro é obrigatória.")
	private BigDecimal largura;

	@NotNull(message = "O peso do livro é obrigatório.")
	private BigDecimal peso;

	@NotNull(message = "A profundidade do livro é obrigatória.")
	private BigDecimal profundidade;

	@NotNull(message = "O código de barras do livro é obrigatório.")
	private String codigoBarras;

	@NotNull(message = "O grupo de precificação do livro é obrigatório.")
	private Long grupoPrecificacaoId;

	@NotNull(message = "O idioma do livro é obrigatório.")
	private Long idiomaId;

	@NotNull(message = "A condição do livro é obrigatório.")
	private Long condicaoId;

	@NotNull(message = "O valor de venda do livro é obrigatório.")
	private BigDecimal valorVenda;

	@NotNull(message = "A capa do livro é obrigatória.")
	private String capa;

}
