package br.com.fatecmogi.controller.dto.vendas;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FiltrarVendasCommand {

	private String dataInicio;

	private String dataFim;

	private List<String> categoriasId;

	public LocalDate getConvertedDataInicio() {
		if (dataInicio == null || dataInicio.isBlank())
			return null;
		return YearMonth.parse(dataInicio).atDay(1);
	}

	public LocalDate getConvertedDataFim() {
		if (dataFim == null || dataFim.isBlank())
			return null;
		return YearMonth.parse(dataFim).atEndOfMonth();
	}

}
