package br.com.fatecmogi.controller.dto.endereco;

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
public class EditarEnderecoClienteCommand {

    @NotNull
    private Long tipoResidenciaId;

    @NotNull
    private Long tipoLogradouroId;

    @NotBlank
    private String logradouro;

    @NotBlank
    private String numero;

    @NotBlank
    private String bairro;

    @NotBlank
    private String cidade;

    @NotBlank
    private String estado;

    @NotBlank
    private String pais;

    @NotBlank
    private String cep;

    private String observacoes;

    @NotBlank
    private String fraseIdentificacao;

    @NotNull
    private Long clienteId;

    @NotBlank
    private String tipoEndereco;

}
