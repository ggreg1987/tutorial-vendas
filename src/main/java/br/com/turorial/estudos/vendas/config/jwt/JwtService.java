package br.com.turorial.estudos.vendas.config.jwt;

import br.com.turorial.estudos.vendas.domain.entity.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class JwtService {

    @Value("{security.jwt.expiracao}")
    private String expiracao;

    @Value("{security.jwt.chave-assinatura}")
    private String assinatura;

    public String gerarToken(Usuario usuario) {
        Long expiracaoString = Long.valueOf(expiracao);
        LocalDateTime now = LocalDateTime.now().plusMinutes(expiracaoString);
        Date data = Date.from(now.atZone(ZoneId.systemDefault()));
    }
}
