package br.com.turorial.estudos.vendas.domain.rest.service.impl;

import br.com.turorial.estudos.vendas.domain.entity.ItemPedido;
import br.com.turorial.estudos.vendas.domain.entity.Pedido;
import br.com.turorial.estudos.vendas.domain.entity.Produto;
import br.com.turorial.estudos.vendas.domain.repository.ClienteRepository;
import br.com.turorial.estudos.vendas.domain.repository.ItempedidoRepository;
import br.com.turorial.estudos.vendas.domain.repository.PedidoRepository;
import br.com.turorial.estudos.vendas.domain.repository.ProdutoRepository;
import br.com.turorial.estudos.vendas.domain.rest.dto.ItemPedidoDTO;
import br.com.turorial.estudos.vendas.domain.rest.dto.PedidoDTO;
import br.com.turorial.estudos.vendas.domain.rest.service.interfaces.PedidoService;
import br.com.turorial.estudos.vendas.exception.RegraBadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ProdutoRepository produtoRepository;
    private final ClienteRepository clienteRepository;
    private final ItempedidoRepository itempedidoRepository;

    @Override
    public Pedido salvar(PedidoDTO dto) {
        return null;
    }

    private List<ItemPedido> items(Pedido pedido, List<ItemPedidoDTO> itens) {
        if(itens.isEmpty()) {
            throw new RegraBadRequestException("Não é possível realizar pedido sem itens!");
        }

        return itens
                .stream()
                .map(dto -> {
                    Long produtoId = dto.getProduto();

                    Produto produto = produtoRepository
                            .findById(produtoId)
                            .orElseThrow(() ->
                                    new RegraBadRequestException("Código de produto inválido"));

                    BigDecimal preco = produto.getPrecoUnitario();
                    Integer quantidade = dto.getQuantidade();
                    BigDecimal multiplicar = new BigDecimal(quantidade);
                })
    }
}
