package br.com.turorial.estudos.vendas.domain.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InformacoesPedidoDTO {

    private Long pedidoId;
    private String nomeCliente;
    private String cpfCliente;
    private String dataPedido;
    private BigDecimal total;
    private String status;
    private List<InformacoesItensPedidoDTO> itensCliente;

}
