package br.com.fatecmogi.repository.table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tipos_logradouro")
@Getter
@Setter
public class PanacheTipoLogradouro extends PanacheEntityBase {

    @Id
    @Column(name = "tpl_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tpl_nome")
    private String nome;

}
