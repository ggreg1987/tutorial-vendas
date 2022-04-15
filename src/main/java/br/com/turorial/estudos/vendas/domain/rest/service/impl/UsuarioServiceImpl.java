package br.com.turorial.estudos.vendas.domain.rest.service.impl;

import br.com.turorial.estudos.vendas.domain.entity.Usuario;
import br.com.turorial.estudos.vendas.domain.repository.UsuarioRepository;
import br.com.turorial.estudos.vendas.domain.rest.dto.CredenciaisDTO;
import br.com.turorial.estudos.vendas.domain.rest.dto.TokenDTO;
import br.com.turorial.estudos.vendas.domain.rest.service.interfaces.UsuarioService;
import br.com.turorial.estudos.vendas.exception.RegraBadRequestException;
import br.com.turorial.estudos.vendas.exception.SenhaInvalidaException;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements UserDetailsService, UsuarioService {


    private PasswordEncoder passwordEncoder;
    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(@Lazy PasswordEncoder passwordEncoder,@Lazy UsuarioRepository usuarioRepository) {
        this.passwordEncoder = passwordEncoder;
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public Usuario salvar(Usuario usuario) {
        boolean loginExistente = usuarioRepository.existsByLogin(usuario.getLogin());
        if(loginExistente) {
            throw new RegraBadRequestException("Usuário já existe no banco de dados");
        } else {
            String encoder = passwordEncoder.encode(usuario.getPassword());
            usuario.setPassword(encoder);
            return usuarioRepository.save(usuario);
        }
    }

    @Override
    public TokenDTO autenticarCredenciais(CredenciaisDTO credenciais) {
        return null;
    }

    public UserDetails autenticar(Usuario usuario) {
        UserDetails user = loadUserByUsername(usuario.getLogin());
        boolean matches = passwordEncoder
                .matches(usuario.getPassword(), user.getPassword());
        if(matches) {
            return user;
        }
        throw new SenhaInvalidaException();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        String[] roles = usuario.isAdmin() ? new String[]{"ADMIN","USER"} : new String[]{"USER"};

        return User
                .builder()
                .username(usuario.getLogin())
                .password(usuario.getPassword())
                .roles(roles)
                .build();
    }
}
