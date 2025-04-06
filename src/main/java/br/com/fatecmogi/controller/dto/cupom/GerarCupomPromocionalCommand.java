package br.com.fatecmogi.controller.dto.cupom;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class GerarCupomPromocionalCommand {

	@NotNull(message = "A porcentagem de desconto do cupom é obrigatória.")
	@Max(value = 1, message = "A porcentagem máxima de desconto é de 100%.")
	private Double porcentagemDesconto;

	@NotBlank(message = "O código do cupom é obrigatória.")
	private String codigo;

}
