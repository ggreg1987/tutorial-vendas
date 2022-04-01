package br.com.turorial.estudos.vendas.domain.rest.controller;

import br.com.turorial.estudos.vendas.domain.rest.service.interfaces.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;
}
