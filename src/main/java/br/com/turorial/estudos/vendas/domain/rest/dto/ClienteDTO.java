package br.com.turorial.estudos.vendas.domain.rest.dto;

import lombok.Data;

@Data
public class ClienteDTO {

    private Long cliente;
    private String nome;
    private String cpf;
}
