package br.com.turorial.estudos.vendas.domain.rest.service.interfaces;

import br.com.turorial.estudos.vendas.domain.entity.Usuario;
import br.com.turorial.estudos.vendas.domain.rest.dto.CredenciaisDTO;
import br.com.turorial.estudos.vendas.domain.rest.dto.TokenDTO;
import org.springframework.web.bind.annotation.RequestBody;

public interface UsuarioService {
    Usuario salvar(Usuario usuario);
    TokenDTO autenticarCredenciais(@RequestBody CredenciaisDTO credenciais);
}
