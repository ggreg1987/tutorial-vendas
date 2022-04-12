package br.com.turorial.estudos.vendas.config.jwt;

import br.com.turorial.estudos.vendas.domain.rest.service.impl.UsuarioServiceImpl;
import io.jsonwebtoken.Claims;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthFilter extends OncePerRequestFilter {

    private JwtService jwtService;
    private UsuarioServiceImpl usuarioService;

    public JwtAuthFilter(JwtService jwtService, UsuarioServiceImpl usuarioService) {
        this.jwtService = jwtService;
        this.usuarioService = usuarioService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
                                    throws ServletException, IOException {
        String authorization = request.getHeader("Authorization");
        if(authorization != null && authorization.startsWith("Bearer")) {
            String token = authorization.split(" ")[1];
            boolean tokenValido = jwtService.tokenValido(token);

            if(tokenValido) {
                String loginUsuario = jwtService.obterLoginUsuario(token);
                UserDetails userDetails = usuarioService.loadUserByUsername(loginUsuario);
                UsernamePasswordAuthenticationToken user =
                        new UsernamePasswordAuthenticationToken(userDetails,
                                null,userDetails.getAuthorities());
            }
        }


    }
}
