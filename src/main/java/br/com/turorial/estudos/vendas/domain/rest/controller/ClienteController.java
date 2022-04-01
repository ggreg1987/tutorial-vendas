package br.com.turorial.estudos.vendas.domain.rest.controller;

import br.com.turorial.estudos.vendas.domain.entity.Cliente;
import br.com.turorial.estudos.vendas.domain.rest.dto.ClienteDTO;
import br.com.turorial.estudos.vendas.domain.rest.service.interfaces.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("api/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;

    @PostMapping
    @ResponseStatus(CREATED)
    Cliente salvar(@RequestBody ClienteDTO dto) {
        return service.salvar(dto);
    }

    @GetMapping("{id}")
    Cliente pesquisarId(@PathVariable Long id) {
        return service.pesquisarId(id);
    }

    @GetMapping
    List<Cliente> pesquisarTodos(Cliente filtro) {
        return service.pesquisarTodos(filtro);
    }
}
