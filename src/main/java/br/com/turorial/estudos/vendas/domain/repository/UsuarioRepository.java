package br.com.turorial.estudos.vendas.domain.repository;

import br.com.turorial.estudos.vendas.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    Optional<Usuario> findByLogin(String login);
    boolean existsByLogin(String login);
}
