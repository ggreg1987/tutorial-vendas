package br.com.turorial.estudos.vendas.domain.rest.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoDTO {

    private Integer quantidade;
    private Long produto;

}
