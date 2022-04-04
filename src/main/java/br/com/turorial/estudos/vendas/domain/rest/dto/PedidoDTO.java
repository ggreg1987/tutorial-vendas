package br.com.turorial.estudos.vendas.domain.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {

    @NotEmpty(message = "{campo.codigo-cliente.obrigatorio}")
    private Long cliente;

    @NotNull(message = "{campo.total-pedido.obrigatorio}")
    private BigDecimal total;
    private LocalDate dataPedido;
    private List<ItemPedidoDTO> itens;
}
