package br.com.turorial.estudos.vendas.domain.rest.service.impl;

import br.com.turorial.estudos.vendas.domain.entity.ItemPedido;
import br.com.turorial.estudos.vendas.domain.entity.Pedido;
import br.com.turorial.estudos.vendas.domain.enums.StatusPedido;
import br.com.turorial.estudos.vendas.domain.repository.PedidoRepository;
import br.com.turorial.estudos.vendas.domain.rest.dto.InformacoesItensPedidoDTO;
import br.com.turorial.estudos.vendas.domain.rest.dto.InformacoesPedidoDTO;
import br.com.turorial.estudos.vendas.domain.rest.service.interfaces.InformacaoPedidoService;
import br.com.turorial.estudos.vendas.exception.RegraNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InformacaoPedidoImpl implements InformacaoPedidoService {

    private final PedidoRepository pedidoRepository;

    @Override
    public InformacoesPedidoDTO informacaoPedidoCompleto(Long id) {
        InformacoesPedidoDTO pedido = pedidoRepository
                .procurarPedido(id)
                .map(pedidoEncontrado -> pedido(pedidoEncontrado))
                .orElseThrow(() -> new RegraNotFoundException("Pedido não encontrado"));
        return pedido;
    }

    private List<InformacoesItensPedidoDTO> items(List<ItemPedido> itens) {
        if(CollectionUtils.isEmpty(itens)) {
            return Collections.emptyList();
        }

        return itens
                .stream()
                .map(item -> {
                    InformacoesItensPedidoDTO info = InformacoesItensPedidoDTO
                            .builder()
                            .precoUnitario(item.getProtudo().getPrecoUnitario())
                            .quantidade(item.getQuantidade())
                            .descricaoProduto(item.getProtudo().getDescricao())
                            .build();
                    return info;
                }).collect(Collectors.toList());
    }

    private InformacoesPedidoDTO pedido(Pedido pedido) {
        return InformacoesPedidoDTO
                .builder()
                .pedidoId(pedido.getId())
                .nomeCliente(pedido.getCliente().getNome())
                .cpfCliente(pedido.getCliente().getCpf())
                .dataPedido(
                        pedido.getData().
                                format(DateTimeFormatter
                                        .ofPattern("dd/MM/yyyy"))
                ).status(pedido.getStatusPedido().name())
                .total(pedido.getTotal())
                .itensCliente(items(pedido.getItens()))
                .build();

    }

    @Override
    public void atualizarStatus(Long id, StatusPedido status) {
        pedidoRepository.findById(id)
                .map(pedido -> {
                    pedido.setStatusPedido(status);
                    return pedidoRepository.save(pedido);
                }).orElseThrow(() -> new RegraNotFoundException("Pedido não encontrado"));
    }
}
