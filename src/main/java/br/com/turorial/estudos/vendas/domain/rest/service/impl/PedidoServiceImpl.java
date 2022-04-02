package br.com.turorial.estudos.vendas.domain.rest.service.impl;

import br.com.turorial.estudos.vendas.domain.entity.ItemPedido;
import br.com.turorial.estudos.vendas.domain.entity.Pedido;
import br.com.turorial.estudos.vendas.domain.repository.ClienteRepository;
import br.com.turorial.estudos.vendas.domain.repository.PedidoRepository;
import br.com.turorial.estudos.vendas.domain.repository.ProdutoRepository;
import br.com.turorial.estudos.vendas.domain.rest.dto.ItemPedidoDTO;
import br.com.turorial.estudos.vendas.domain.rest.dto.PedidoDTO;
import br.com.turorial.estudos.vendas.domain.rest.service.interfaces.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ProdutoRepository produtoRepository;
    private final ClienteRepository clienteRepository;

    @Override
    public Pedido salvar(PedidoDTO dto) {
        return null;
    }

    private List<ItemPedido> items(Pedido pedido, ItemPedidoDTO itens) {

    }
}