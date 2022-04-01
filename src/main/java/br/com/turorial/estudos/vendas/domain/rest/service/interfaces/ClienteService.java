package br.com.turorial.estudos.vendas.domain.rest.service.interfaces;

import br.com.turorial.estudos.vendas.domain.entity.Cliente;
import br.com.turorial.estudos.vendas.domain.rest.dto.ClienteDTO;

public interface ClienteService {
    Cliente salvar(ClienteDTO dto);
}
