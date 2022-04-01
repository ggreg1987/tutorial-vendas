package br.com.turorial.estudos.vendas.domain.entity;

import br.com.turorial.estudos.vendas.domain.enums.StatusPedido;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(precision = 20, scale = 2)
    private BigDecimal total;
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    private StatusPedido statusPedido;

    @OneToMany(mappedBy = "pedido",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ItemPedido> itens;

    public List<ItemPedido> getItens() {
        if(itens == null) {
            itens = new ArrayList<>();
        }
        return itens;
    }

}
