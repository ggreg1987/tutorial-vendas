package br.com.turorial.estudos.vendas.domain.rest.dto;

import br.com.turorial.estudos.vendas.validation.NotEmptList;
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

    @NotNull(message = "{campo.codigo-cliente.obrigatorio}")
    private Long cliente;

    @NotNull(message = "{campo.total-pedido.obrigatorio}")
    private BigDecimal total;
    private LocalDate dataPedido;

    @NotEmptList(message = "{campo.pedido-lista.obrigatoio}")
    private List<ItemPedidoDTO> itens;
}
