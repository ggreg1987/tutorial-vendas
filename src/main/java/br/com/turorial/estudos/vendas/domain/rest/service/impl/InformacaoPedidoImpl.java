package br.com.turorial.estudos.vendas.domain.rest.service.impl;

import br.com.turorial.estudos.vendas.domain.entity.ItemPedido;
import br.com.turorial.estudos.vendas.domain.entity.Pedido;
import br.com.turorial.estudos.vendas.domain.rest.dto.InformacoesItensPedidoDTO;
import br.com.turorial.estudos.vendas.domain.rest.dto.InformacoesPedidoDTO;
import br.com.turorial.estudos.vendas.domain.rest.service.interfaces.InformacaoPedidoService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InformacaoPedidoImpl implements InformacaoPedidoService {

    @Override
    public InformacoesPedidoDTO informacaoPedidoCompleto(Long id) {
        return null;
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
        
    }
}
