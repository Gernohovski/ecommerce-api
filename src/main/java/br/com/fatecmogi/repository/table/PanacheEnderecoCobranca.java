package br.com.fatecmogi.repository.table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "enderecos_cobranca")
@Getter
@Setter
public class PanacheEnderecoCobranca extends PanacheEntityBase {

    @Id
    @Column(name = "ecb_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ecb_tpr_id", referencedColumnName = "tpr_id")
    private PanacheTipoResidencia tipoResidencia;

    @ManyToOne
    @JoinColumn(name = "ecb_tpl_id", referencedColumnName = "tpl_id")
    private PanacheTipoLogradouro tipoLogradouro;

    @Column(name = "ecb_logradouro")
    private String logradouro;

    @Column(name = "ecb_numero")
    private String numero;

    @Column(name = "ecb_bairro")
    private String bairro;

    @Column(name = "ecb_estado")
    private String estado;

    @Column(name = "ecb_cidade")
    private String cidade;

    @Column(name = "ecb_pais")
    private String pais;

    @Column(name = "ecb_cep")
    private String cep;

    @Column(name = "ecb_observacoes")
    private String observacoes;

    @Column(name = "ecb_frase_identificacao")
    private String fraseIdentificacao;

    @ManyToOne
    @JoinColumn(name = "ecb_clt_id", referencedColumnName = "clt_id")
    private PanacheCliente cliente;

    public void unreferrenceDependecies() {
        this.tipoLogradouro = null;
        this.tipoResidencia = null;
    }
}
