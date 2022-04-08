package br.com.turorial.estudos.vendas.domain.rest.controller;

import br.com.turorial.estudos.vendas.domain.rest.service.impl.UsuarioServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioServiceImpl usuarioService;

}
