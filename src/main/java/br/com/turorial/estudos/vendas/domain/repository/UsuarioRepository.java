package br.com.turorial.estudos.vendas.domain.repository;

import br.com.turorial.estudos.vendas.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
