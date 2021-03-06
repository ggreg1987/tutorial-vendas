package br.com.turorial.estudos.vendas.domain.rest.service.impl;

import br.com.turorial.estudos.vendas.domain.entity.Cliente;
import br.com.turorial.estudos.vendas.domain.entity.ItemPedido;
import br.com.turorial.estudos.vendas.domain.entity.Pedido;
import br.com.turorial.estudos.vendas.domain.entity.Produto;
import br.com.turorial.estudos.vendas.domain.enums.StatusPedido;
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
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ProdutoRepository produtoRepository;
    private final ClienteRepository clienteRepository;
    private final ItempedidoRepository itempedidoRepository;

    @Override
    @Transactional
    public Pedido salvar(PedidoDTO dto) {
        Long clienteId = dto.getCliente();
        Cliente cliente = clienteRepository
                .findById(clienteId)
                .orElseThrow(() -> new RegraBadRequestException("Cliente não encontrado"));

        Pedido pedido = Pedido
                .builder()
                .cliente(cliente)
                .total(dto.getTotal())
                .statusPedido(StatusPedido.REALIZADO)
                .data(LocalDate.now())
                .build();

        List<ItemPedido> itens = items(pedido, dto.getItens());
        itempedidoRepository.saveAll(itens);
        pedido.setItens(itens);
        return pedidoRepository.save(pedido);
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
                    BigDecimal quantidadeBig = new BigDecimal(quantidade);

                    BigDecimal total = preco.multiply(quantidadeBig);

                    pedido.setTotal(total);

                    ItemPedido itemPedido = ItemPedido
                            .builder()
                            .pedido(pedido)
                            .protudo(produto)
                            .quantidade(quantidade)
                            .build();
                    return itemPedido;
                }).collect(Collectors.toList());
    }
}
