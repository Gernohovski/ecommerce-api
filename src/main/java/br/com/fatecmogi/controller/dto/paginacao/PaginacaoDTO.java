package br.com.fatecmogi.controller.dto.paginacao;

import jakarta.ws.rs.QueryParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class PaginacaoDTO {

	@QueryParam("pagina")
	private int page = 0;

	@QueryParam("tamanho")
	private int size = 10;

}
