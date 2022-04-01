package br.com.turorial.estudos.vendas.domain.repository;

import br.com.turorial.estudos.vendas.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido,Long> {
}
