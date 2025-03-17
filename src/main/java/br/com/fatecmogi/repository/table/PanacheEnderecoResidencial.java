package br.com.fatecmogi.repository.table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "enderecos_residencial")
@Getter
@Setter
public class PanacheEnderecoResidencial extends PanacheEntityBase {

    @Id
    @Column(name = "ers_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ers_tpr_id", referencedColumnName = "tpr_id")
    private PanacheTipoResidencia tipoResidencia;

    @ManyToOne
    @JoinColumn(name = "ers_tpl_id", referencedColumnName = "tpl_id")
    private PanacheTipoLogradouro tipoLogradouro;

    @Column(name = "ers_logradouro")
    private String logradouro;

    @Column(name = "ers_numero")
    private String numero;

    @Column(name = "ers_bairro")
    private String bairro;

    @Column(name = "ers_estado")
    private String estado;

    @Column(name = "ers_cidade")
    private String cidade;

    @Column(name = "ers_pais")
    private String pais;

    @Column(name = "ers_cep")
    private String cep;

    @Column(name = "ers_observacoes")
    private String observacoes;

    @Column(name = "ers_frase_identificacao")
    private String fraseIdentificacao;

    @Column(name = "ers_principal")
    private boolean principal;

    @ManyToOne
    @JoinColumn(name = "ers_clt_id", referencedColumnName = "clt_id")
    private PanacheCliente cliente;

    public void unreferrenceDependecies() {
        this.tipoLogradouro = null;
        this.tipoResidencia = null;
    }

}
