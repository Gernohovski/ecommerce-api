package br.com.fatecmogi.repository.table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tipos_telefone")
@Getter
@Setter
public class PanacheTipoTelefone extends PanacheEntityBase {

    @Id
    @Column(name = "tpf_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tpf_nome")
    private String nome;

}
