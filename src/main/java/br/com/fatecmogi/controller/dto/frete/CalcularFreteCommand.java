package br.com.fatecmogi.controller.dto.frete;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class CalcularFreteCommand {

	@NotBlank(message = "O identificador único do endereço de entrega é obrigatório.")
	private Long enderecoId;

	@NotBlank(message = "O peso do pacote é obrigatório.")
	private Double peso;

}
