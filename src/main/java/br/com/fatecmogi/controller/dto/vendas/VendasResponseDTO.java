package br.com.fatecmogi.controller.dto.vendas;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VendasResponseDTO {

	@Builder.Default
	private String name = "Número de vendas por categoria";

	private List<SerieLinhaResponseDTO> series;

	private List<String> categories;

	private int numeroVendas;

	private Long novosClientes;

}
