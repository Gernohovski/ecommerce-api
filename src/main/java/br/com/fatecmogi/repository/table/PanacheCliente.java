package br.com.fatecmogi.repository.table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes")
@Getter
@Setter
public class PanacheCliente extends PanacheEntityBase {

    @Id
    @Column(name = "clt_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "clt_gen_id", referencedColumnName = "gen_id")
    private PanacheGenero genero;

    @Column(name = "clt_nome")
    private String nome;

    @Column(name = "clt_data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "clt_cpf")
    private String cpf;

    @Column(name = "clt_email")
    private String email;

    @Column(name = "clt_senha")
    private String senha;

    @Column(name = "clt_ativo")
    private boolean ativo;

    @OneToOne
    @JoinColumn(name = "clt_tlf_id", referencedColumnName = "tlf_id")
    private PanacheTelefone telefone;

    @OneToMany(mappedBy = "cliente")
    private List<PanacheEnderecoResidencial> enderecoResidencial;

    @OneToMany(mappedBy = "cliente")
    private List<PanacheEnderecoCobranca> enderecoCobranca;

    @OneToMany(mappedBy = "cliente")
    private List<PanacheEnderecoEntrega> enderecoEntrega;

    @OneToMany(mappedBy = "cliente")
    private List<PanacheCartaoCredito> cartaoCredito;

    public void persistDependecies() {
        PanacheEnderecoResidencial.persist(this.enderecoResidencial);
        PanacheEnderecoCobranca.persist(this.enderecoCobranca);
        PanacheEnderecoEntrega.persist(this.enderecoEntrega);
        PanacheCartaoCredito.persist(this.cartaoCredito);
        PanacheTelefone.persist(this.telefone);
    }

    public void unreferrenceDependecies() {
        this.enderecoResidencial = null;
        this.enderecoCobranca = null;
        this.enderecoEntrega = null;
        this.telefone = null;
    }

}
