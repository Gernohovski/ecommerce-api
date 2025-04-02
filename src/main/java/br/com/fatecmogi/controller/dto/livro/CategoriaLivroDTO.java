package br.com.fatecmogi.controller.dto.livro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaLivroDTO {

    private Long id;

    private String nome;

}
