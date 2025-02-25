package br.com.fatecmogi.repository.table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "bandeiras_cartao")
@Getter
@Setter
public class PanacheBandeiraCartao extends PanacheEntityBase {

    @Id
    @Column(name = "bnc_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bnc_nome")
    private String nome;

}
