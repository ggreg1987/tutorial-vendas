package br.com.turorial.estudos.vendas.domain.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {

    private Long produto;

    @NotEmpty(message = "{campo.descricao.obrigatorio}")
    private String descricao;
    private BigDecimal precoUnitario;
}
