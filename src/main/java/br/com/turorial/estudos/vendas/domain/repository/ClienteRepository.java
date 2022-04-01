package br.com.turorial.estudos.vendas.domain.repository;


import br.com.turorial.estudos.vendas.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
