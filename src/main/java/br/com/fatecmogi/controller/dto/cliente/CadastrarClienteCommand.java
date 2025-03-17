package br.com.fatecmogi.controller.dto.cliente;

import br.com.fatecmogi.model.entity.cartaoCredito.CartaoCredito;
import br.com.fatecmogi.model.entity.cliente.Genero;
import br.com.fatecmogi.model.entity.endereco.EnderecoCobranca;
import br.com.fatecmogi.model.entity.endereco.EnderecoEntrega;
import br.com.fatecmogi.model.entity.endereco.EnderecoResidencial;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class CadastrarClienteCommand {

    @NotNull(message = "Genêro é obrigatório.")
    private Long generoId;

    @NotBlank(message = "Nome é obrigatório.")
    private String nome;

    @NotNull(message = "Data de nascimento é obrigatória.")
    private LocalDate dataNascimento;

    @NotBlank(message = "CPF é obrigatório.")
    @CPF(message = "O CPF inserido é inválido.")
    private String cpf;

    @NotBlank(message = "E-mail é obrigatório.")
    @Email(message = "E-mail inserido inválido.")
    private String email;

    @NotBlank(message = "Senha é obrigatória.")
    private String senha;

    @NotBlank(message = "Telefone é obrigatório.")
    private String telefone;

    @NotNull(message = "Tipo do telefone é obrigatório.")
    private Long tipoTelefoneId;

    @NotBlank(message = "DDD do telefone é obrigatório.")
    private String ddd;

    @NotNull
    @Size(min = 1, message = "O cliente deve conter ao menos um endereço residencial.")
    private List<EnderecoResidencial> enderecoResidencial;

    @NotNull
    @Size(min = 1, message = "O cliente deve conter ao menos um endereço de cobrança.")
    private List<EnderecoCobranca> enderecoCobranca;

    @NotNull
    @Size(min = 1, message = "O cliente deve conter ao menos um endereço de cobrança.")
    private List<EnderecoEntrega> enderecoEntrega;

    @NotNull
    @Size(min = 1, message = "O cliente deve conter ao menos um cartão de crédito.")
    private List<CartaoCredito> cartaoCredito;

    @AssertTrue(message = "Data de nascimento não pode ser posterior a hoje.")
    public boolean isDataNascimentoBeforeNow() {
        return dataNascimento != null && !dataNascimento.isAfter(LocalDate.now());
    }
}
