package br.com.fatecmogi.model.entity.cartaoCredito;

import br.com.fatecmogi.model.entity.cliente.Cliente;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection
public class CartaoCredito {

    private Long id;

    private String numero;

    private String nomeImpresso;

    private BandeiraCartao bandeira;

    private String codigoSeguranca;

    @Builder.Default
    private boolean principal = false;

    private Cliente cliente;

}
