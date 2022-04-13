package br.com.turorial.estudos.vendas.domain.rest.controller;

import br.com.turorial.estudos.vendas.config.jwt.JwtService;
import br.com.turorial.estudos.vendas.domain.entity.Usuario;
import br.com.turorial.estudos.vendas.domain.rest.dto.CredenciaisDTO;
import br.com.turorial.estudos.vendas.domain.rest.dto.TokenDTO;
import br.com.turorial.estudos.vendas.domain.rest.service.impl.UsuarioServiceImpl;
import br.com.turorial.estudos.vendas.exception.SenhaInvalidaException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioServiceImpl usuarioService;
    private final JwtService jwtService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario salvar(@RequestBody Usuario usuario) {
        return usuarioService.salvar(usuario);
    }

    @PostMapping("/auth")
    public TokenDTO autenticar(@RequestBody CredenciaisDTO credenciais) {
        try {
            Usuario usuario = Usuario.builder()
                    .login(credenciais.getLogin())
                    .password(credenciais.getSenha())
                    .build();
            UserDetails autenticar = usuarioService.autenticar(usuario);
            String token = jwtService.gerarToken(usuario);
            return new TokenDTO(usuario.getLogin(), token);
        } catch (UsernameNotFoundException e) {

        } catch (SenhaInvalidaException e) {

        }
    }

}
