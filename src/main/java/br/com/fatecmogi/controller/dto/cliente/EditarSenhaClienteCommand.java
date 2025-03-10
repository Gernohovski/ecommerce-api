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

    @NotBlank
    private String senhaAtual;

    @NotBlank
    private String senha;

}
