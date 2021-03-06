package br.com.turorial.estudos.vendas.domain.rest.controller;

import br.com.turorial.estudos.vendas.domain.entity.Pedido;
import br.com.turorial.estudos.vendas.domain.enums.StatusPedido;
import br.com.turorial.estudos.vendas.domain.rest.dto.InformacoesPedidoDTO;
import br.com.turorial.estudos.vendas.domain.rest.dto.PedidoDTO;
import br.com.turorial.estudos.vendas.domain.rest.dto.StatusPedidoDTO;
import br.com.turorial.estudos.vendas.domain.rest.service.interfaces.InformacaoPedidoService;
import br.com.turorial.estudos.vendas.domain.rest.service.interfaces.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("api/pedido")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService service;
    private final InformacaoPedidoService infoService;

    @PostMapping
    @ResponseStatus(CREATED)
    public Long salvar(@RequestBody @Valid PedidoDTO dto) {
        Pedido pedido = service.salvar(dto);
        return pedido.getId();
    }

    @GetMapping("{id}")
    InformacoesPedidoDTO informacaoPedidoCompleto(@PathVariable Long id) {
        return infoService.informacaoPedidoCompleto(id);
    }

    @PatchMapping("{id}")
    void atualizarStatus(@PathVariable Long id,@RequestBody StatusPedidoDTO dto) {
        String status = dto.getStatusAtual();
        infoService.atualizarStatus(id,StatusPedido.valueOf(status));
    }
}
