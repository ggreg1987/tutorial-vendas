package br.com.turorial.estudos.vendas.domain.repository;

import br.com.turorial.estudos.vendas.domain.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItempedidoRepository extends JpaRepository<ItemPedido,Long> {
}
