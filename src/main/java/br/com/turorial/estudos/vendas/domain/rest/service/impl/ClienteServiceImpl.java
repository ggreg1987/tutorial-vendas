package br.com.turorial.estudos.vendas.domain.rest.service.impl;

import br.com.turorial.estudos.vendas.domain.entity.Cliente;
import br.com.turorial.estudos.vendas.domain.repository.ClienteRepository;
import br.com.turorial.estudos.vendas.domain.rest.dto.ClienteDTO;
import br.com.turorial.estudos.vendas.domain.rest.service.interfaces.ClienteService;
import br.com.turorial.estudos.vendas.exception.RegraNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;


    @Override
    public Cliente salvar(ClienteDTO dto) {
        Cliente cliente = Cliente.builder()
                .nome(dto.getNome())
                .cpf(dto.getCpf())
                .build();
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente pesquisarId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RegraNotFoundException("Cliente não encontrado"));
        return cliente;
    }

    @Override
    public List<Cliente> pesquisarTodos(Cliente filtro) {
        ExampleMatcher exampleMatcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(filtro,exampleMatcher);
    }
}
