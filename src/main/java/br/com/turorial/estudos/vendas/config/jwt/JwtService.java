package br.com.turorial.estudos.vendas.config.jwt;

import br.com.turorial.estudos.vendas.VendasApplication;
import br.com.turorial.estudos.vendas.domain.entity.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class JwtService {

    @Value("{security.jwt.expiracao}")
    private String expiracao;

    @Value("{security.jwt.chave-assinatura}")
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

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(VendasApplication.class);
        context.getBean(JwtService.class);
    }
}
