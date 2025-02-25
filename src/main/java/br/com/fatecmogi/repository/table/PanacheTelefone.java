package br.com.fatecmogi.repository.table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "telefones")
@Getter
@Setter
public class PanacheTelefone extends PanacheEntityBase {

    @Id
    @Column(name = "tlf_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tlf_ddd")
    private String ddd;

    @Column(name = "tlf_telefone")
    private String telefone;

    @ManyToOne
    @JoinColumn(name = "tlf_tpf_id", referencedColumnName = "tpf_id")
    private PanacheTipoTelefone tipoTelefone;

}
