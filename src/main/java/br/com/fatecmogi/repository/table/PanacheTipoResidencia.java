package br.com.fatecmogi.repository.table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tipos_residencia")
@Getter
@Setter
public class PanacheTipoResidencia extends PanacheEntityBase {

    @Id
    @Column(name = "tpr_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tpr_nome")
    private String nome;

}
