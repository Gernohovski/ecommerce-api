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
public class SerieLinhaResponseDTO {

	private String name;

	private List<Double> data;

}
