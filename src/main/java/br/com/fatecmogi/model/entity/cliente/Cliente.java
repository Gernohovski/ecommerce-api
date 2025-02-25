package br.com.fatecmogi.model.entity.cliente;

import br.com.fatecmogi.model.entity.cartaoCredito.CartaoCredito;
import br.com.fatecmogi.model.entity.endereco.EnderecoCobranca;
import br.com.fatecmogi.model.entity.endereco.EnderecoEntrega;
import br.com.fatecmogi.model.entity.endereco.EnderecoResidencial;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection
public class Cliente {

    private Long id;

    private Genero genero;

    private String nome;

    private LocalDate dataNascimento;

    private String cpf;

    private String email;

    private String senha;

    private Telefone telefone;

    @Builder.Default
    private boolean ativo = true;

    private List<EnderecoResidencial> enderecoResidencial;

    private List<EnderecoCobranca> enderecoCobranca;

    private List<EnderecoEntrega> enderecoEntrega;

    private List<CartaoCredito> cartaoCredito;

}
