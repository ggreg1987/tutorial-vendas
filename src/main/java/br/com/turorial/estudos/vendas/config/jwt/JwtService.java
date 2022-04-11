package br.com.turorial.estudos.vendas.config.jwt;

import br.com.turorial.estudos.vendas.VendasApplication;
import br.com.turorial.estudos.vendas.domain.entity.Usuario;
import ch.qos.logback.core.net.SyslogOutputStream;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

@Service
public class JwtService {

    @Value("${security.jwt.expiracao}")
    private String expiracao;

    @Value("${security.jwt.chave-assinatura}")
    private String assinatura;

    public String gerarToken(Usuario usuario) {
        Long expiracaoString = Long.valueOf(expiracao);
        LocalDateTime now = LocalDateTime.now().plusMinutes(expiracaoString);
        Date data = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());

        return Jwts
                .builder()
                .setSubject(usuario.getLogin())
                .setExpiration(data)
                .signWith(SignatureAlgorithm.HS512,assinatura)
                .compact();
    }

    public Claims obterClaims(String token) throws ExpiredJwtException {
        return Jwts
                .parser()
                .setSigningKey(assinatura)
                .parseClaimsJws(token)
                .getBody();

    }

    private boolean tokenValido(String token) {
        try {
            Claims claims = obterClaims(token);
            Date expiration = claims.getExpiration();
            LocalDateTime dateTime = LocalDateTime.from(expiration.toInstant()
                    .atZone(ZoneId.systemDefault()));
            return !LocalDateTime.now().isAfter(dateTime);
        }catch (Exception e) {
            return false;
        }
    }

    public String obterLoginUsuario(String token) {
        
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(VendasApplication.class);
        JwtService bean = context.getBean(JwtService.class);
        Usuario usuario = Usuario
                .builder()
                .login("gabriel")
                .build();
        String token = bean.gerarToken(usuario);
        System.out.println(token);
    }
}
