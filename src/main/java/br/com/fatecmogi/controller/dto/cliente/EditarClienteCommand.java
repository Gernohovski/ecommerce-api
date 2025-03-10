package br.com.fatecmogi.controller.dto.cliente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class EditarClienteCommand {

    @NotNull(message = "Gênero é obrigatório")
    private Long generoId;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotNull(message = "Data de nascimento é obrigatória")
    private LocalDate dataNascimento;

    @NotBlank(message = "CPF é obrigatório")
    private String cpf;

    @NotBlank(message = "Telefone é obrigatório")
    private String telefone;

    @NotNull(message = "Tipo do telefone é obrigatório")
    private Long tipoTelefoneId;

    @NotBlank(message = "DDD do telefone é obrigatório")
    private String ddd;

    @NotBlank(message = "O e-mail é obrigatório")
    private String email;
    
}
