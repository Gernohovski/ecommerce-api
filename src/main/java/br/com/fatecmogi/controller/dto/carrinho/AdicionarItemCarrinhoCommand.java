package br.com.fatecmogi.controller.dto.carrinho;

import br.com.fatecmogi.model.entity.livro.Livro;
import br.com.fatecmogi.model.entity.pedido.Carrinho;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class AdicionarItemCarrinhoCommand {

    @NotBlank(message = "Livro é obrigatório.")
    private Long livroId;

    @NotBlank(message = "Quantidade de livros é obrigatória.")
    private Integer quantidade;

}
