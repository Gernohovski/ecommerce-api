package br.com.fatecmogi.repository.table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "solicitacoes_devolucao")
@Getter
@Setter
public class PanacheSolicitacaoDevolucao extends PanacheEntityBase {

    @Id
    @Column(name = "std_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(name = "itens_pedido_solicitacao_devolucao", joinColumns = @JoinColumn(name = "std_id"),
            inverseJoinColumns = @JoinColumn(name = "itp_id"))
    private Set<PanacheItemPedido> itensPedido;

    @ManyToOne
    @JoinColumn(name = "ped_id")
    private PanachePedido pedido;

}
