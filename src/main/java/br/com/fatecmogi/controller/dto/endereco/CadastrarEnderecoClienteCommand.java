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
public class CadastrarEnderecoClienteCommand {

	@NotNull(message = "Tipo da residência do endereço é obrigatória.")
	private Long tipoResidenciaId;

	@NotNull(message = "Tipo do logradouro do endereço é obrigatória.")
	private Long tipoLogradouroId;

	@NotBlank(message = "Logradouro do endereço é obrigatório.")
	private String logradouro;

	@NotBlank(message = "Número do endereço é obrigatório.")
	private String numero;

	@NotBlank(message = "Bairro do endereço é obrigatório.")
	private String bairro;

	@NotBlank(message = "Cidade do endereço é obrigatória.")
	private String cidade;

	@NotBlank(message = "Cidade do endereço é obrigatória.")
	private String estado;

	@NotBlank(message = "País do endereço é obrigatório.")
	private String pais;

	@NotBlank(message = "CEP do endereço é obrigatório.")
	private String cep;

	private String observacoes;

	@NotBlank(message = "Frase de identificação do endereço é obrigatório.")
	private String fraseIdentificacao;

	@NotNull(message = "O cliente do endereço é obrigatório.")
	private Long clienteId;

	@NotBlank(message = "O tipo do endereço é obrigatório.")
	private String tipoEndereco;

}
