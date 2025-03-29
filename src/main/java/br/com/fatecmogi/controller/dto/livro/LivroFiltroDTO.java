package br.com.fatecmogi.controller.dto.livro;

import jakarta.ws.rs.QueryParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class LivroFiltroDTO {

	@QueryParam("precoMin")
	public BigDecimal precoMin;

	@QueryParam("categoriaId")
	public Long categoriaId;

	@QueryParam("autorId")
	public List<Long> autoresId;

	@QueryParam("titulo")
	public String titulo;

	@QueryParam("precoMax")
	public BigDecimal precoMax;

	@QueryParam("condicao")
	public String condicao;

	@QueryParam("idioma")
	public String idioma;

	@QueryParam("sortBy")
	public String sortBy = "valorVenda";

	@QueryParam("sortDirection")
	public String sortDirection = "ASC";

}
