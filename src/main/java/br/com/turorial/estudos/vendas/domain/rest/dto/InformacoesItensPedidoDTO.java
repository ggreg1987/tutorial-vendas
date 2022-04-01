package br.com.turorial.estudos.vendas.domain.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InformacoesItensPedidoDTO {

    private String descricaoProduto;
    private Integer quantidade;
    private BigDecimal precoUnitario;
}
