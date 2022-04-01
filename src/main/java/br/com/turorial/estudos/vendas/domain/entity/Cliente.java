package br.com.turorial.estudos.vendas.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente",orphanRemoval = true,cascade = CascadeType.ALL)
    private List<Pedido> pedidos;

    public List<Pedido> getPedidos() {
        if(pedidos == null) {
            pedidos = new ArrayList<>();
        }
        return pedidos;
    }
}
