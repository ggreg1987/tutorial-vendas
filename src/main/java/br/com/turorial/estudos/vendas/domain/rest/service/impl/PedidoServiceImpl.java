package br.com.turorial.estudos.vendas.domain.rest.service.impl;

import br.com.turorial.estudos.vendas.domain.entity.ItemPedido;
import br.com.turorial.estudos.vendas.domain.entity.Pedido;
import br.com.turorial.estudos.vendas.domain.rest.dto.ItemPedidoDTO;
import br.com.turorial.estudos.vendas.domain.rest.dto.PedidoDTO;
import br.com.turorial.estudos.vendas.domain.rest.service.interfaces.PedidoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {


    @Override
    public Pedido salvar(PedidoDTO dto) {
        return null;
    }

    private List<ItemPedido> items(Pedido pedido, ItemPedidoDTO itens) {
        
    }
}
