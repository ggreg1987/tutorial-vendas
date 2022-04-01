package br.com.turorial.estudos.vendas.domain.rest.controller;

import br.com.turorial.estudos.vendas.domain.entity.Produto;
import br.com.turorial.estudos.vendas.domain.rest.dto.ProdutoDTO;
import br.com.turorial.estudos.vendas.domain.rest.service.interfaces.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/produto")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService service;

    @PostMapping
    @ResponseStatus(CREATED)
    Produto salvar(@RequestBody ProdutoDTO dto) {
        return service.salvar(dto);
    }

    @GetMapping("{id}")
    Produto pesquisarId(@PathVariable Long id) {
        return service.pesquisarId(id);
    }

    @GetMapping
    List<Produto> pesquisar(Produto filtro) {
        return service.pesquisar(filtro);
    }

}
