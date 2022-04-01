package br.com.turorial.estudos.vendas.domain.rest.service.impl;

import br.com.turorial.estudos.vendas.domain.entity.Cliente;
import br.com.turorial.estudos.vendas.domain.repository.ClienteRepository;
import br.com.turorial.estudos.vendas.domain.rest.dto.ClienteDTO;
import br.com.turorial.estudos.vendas.domain.rest.service.interfaces.ClienteService;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    private ClienteRepository clienteRepository;


    @Override
    public Cliente salvar(ClienteDTO dto) {
        return null;
    }
}
