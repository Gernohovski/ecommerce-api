package br.com.fatecmogi.repository.table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "condicoes")
@Getter
@Setter
public class PanacheCondicao extends PanacheEntityBase {

    @Id
    @Column(name = "cnd_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cnd_nome")
    private String nome;


}
