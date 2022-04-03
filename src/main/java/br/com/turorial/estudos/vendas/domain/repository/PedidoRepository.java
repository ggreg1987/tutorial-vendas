package br.com.turorial.estudos.vendas.domain.repository;

import br.com.turorial.estudos.vendas.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PedidoRepository extends JpaRepository<Pedido,Long> {

    @Query("select p from Pedido p left join p.itens where p.id = :id")
    Optional<Pedido> procurarPedido(@Param("id") Long id);
}
