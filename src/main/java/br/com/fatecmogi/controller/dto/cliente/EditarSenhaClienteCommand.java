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
public class EditarSenhaClienteCommand {

	@NotBlank(message = "A senha atual é obrigatória.")
	private String senhaAtual;

	@NotBlank(message = "A nova senha é obrigatória.")
	private String senha;

}
