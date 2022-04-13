package br.com.turorial.estudos.vendas.domain.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TokenDTO {

    private String login;
    private String token;
}
