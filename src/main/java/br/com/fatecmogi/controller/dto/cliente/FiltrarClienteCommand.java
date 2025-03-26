package br.com.fatecmogi.controller.dto.cliente;

import jakarta.ws.rs.QueryParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class FiltrarClienteCommand {

	@Builder.Default
	@QueryParam("page")
	private int page = 0;

	@Builder.Default
	@QueryParam("size")
	private int size = 10;

	@QueryParam("termoPesquisa")
	private String termoPesquisa;

}
