package br.com.fatecmogi.repository.table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cartoes_credito")
@Getter
@Setter
public class PanacheCartaoCredito extends PanacheEntityBase {

    @Id
    @Column(name = "crc_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "crc_numero")
    private String numero;

    @Column(name = "crc_nome_impresso")
    private String nomeImpresso;

    @ManyToOne
    @JoinColumn(name = "crc_bnc_id", referencedColumnName = "bnc_id")
    private PanacheBandeiraCartao bandeira;

    @Column(name = "crc_codigo_segurança")
    private String codigoSeguranca;

    @Column(name = "crc_principal")
    private boolean principal;

    @ManyToOne
    @JoinColumn(name = "crc_clt_id", referencedColumnName = "clt_id")
    private PanacheCliente cliente;

    public void unreferrenceDependecies() {
        this.bandeira = null;
    }
}
