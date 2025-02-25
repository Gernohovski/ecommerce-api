package br.com.fatecmogi.controller.dto.cartaoCredito;

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
public class EditarCartaoCreditoClienteCommand {

    @NotBlank
    private String numero;

    @NotBlank
    private String nomeImpresso;

    @NotNull
    private Long bandeiraId;

    @NotBlank
    private String codigoSeguranca;

    @NotNull
    private Long clienteId;

}
