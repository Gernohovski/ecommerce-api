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
public class CadastrarCartaoCreditoClienteCommand {

    @NotBlank(message = "Número do cartão é obrigatório.")
    private String numero;

    @NotBlank(message = "Nome impresso no do cartão é obrigatório.")
    private String nomeImpresso;

    @NotNull(message = "A bandeira do do cartão é obrigatório.")
    private Long bandeiraId;

    @NotBlank(message = "O código de segurança do cartão é obrigatório.")
    private String codigoSeguranca;

    @NotNull(message = "O cliente do cartão de crédito é obrigatório.")
    private Long clienteId;

}
