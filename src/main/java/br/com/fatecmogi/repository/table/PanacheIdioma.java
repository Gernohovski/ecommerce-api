package br.com.fatecmogi.repository.table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "idiomas")
@Getter
@Setter
public class PanacheIdioma extends PanacheEntityBase {

    @Id
    @Column(name = "idm_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "idm_nome")
    private String nome;

}
