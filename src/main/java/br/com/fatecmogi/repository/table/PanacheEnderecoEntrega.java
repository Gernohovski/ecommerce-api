package br.com.fatecmogi.repository.table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "enderecos_entrega")
@Getter
@Setter
public class PanacheEnderecoEntrega extends PanacheEntityBase {

    @Id
    @Column(name = "eet_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "eet_tpr_id", referencedColumnName = "tpr_id")
    private PanacheTipoResidencia tipoResidencia;

    @ManyToOne
    @JoinColumn(name = "eet_tpl_id", referencedColumnName = "tpl_id")
    private PanacheTipoLogradouro tipoLogradouro;

    @Column(name = "eet_logradouro")
    private String logradouro;

    @Column(name = "eet_numero")
    private String numero;

    @Column(name = "eet_bairro")
    private String bairro;

    @Column(name = "eet_estado")
    private String estado;

    @Column(name = "eet_cidade")
    private String cidade;

    @Column(name = "eet_pais")
    private String pais;

    @Column(name = "eet_cep")
    private String cep;

    @Column(name = "eet_observacoes")
    private String observacoes;

    @Column(name = "eet_frase_identificacao")
    private String fraseIdentificacao;

    @Column(name = "eet_principal")
    private boolean principal;

    @ManyToOne
    @JoinColumn(name = "eet_clt_id", referencedColumnName = "clt_id")
    private PanacheCliente cliente;

    public void unreferrenceDependecies() {
        this.tipoLogradouro = null;
        this.tipoResidencia = null;
    }

}
