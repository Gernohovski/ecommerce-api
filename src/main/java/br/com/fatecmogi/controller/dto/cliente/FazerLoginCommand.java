package br.com.fatecmogi.controller.dto.cliente;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class FazerLoginCommand {

	@NotBlank(message = "E-mail é obrigatório")
	private String email;

	@NotBlank(message = "Senha é obrigatória")
	private String senha;

}
