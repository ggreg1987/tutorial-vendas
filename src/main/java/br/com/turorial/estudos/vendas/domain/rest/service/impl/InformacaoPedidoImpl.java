package br.com.turorial.estudos.vendas.domain.rest.service.impl;

import br.com.turorial.estudos.vendas.domain.entity.ItemPedido;
import br.com.turorial.estudos.vendas.domain.rest.dto.InformacoesItensPedidoDTO;
import br.com.turorial.estudos.vendas.domain.rest.dto.InformacoesPedidoDTO;
import br.com.turorial.estudos.vendas.domain.rest.service.interfaces.InformacaoPedidoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformacaoPedidoImpl implements InformacaoPedidoService {

    @Override
    public InformacoesPedidoDTO informacaoPedidoCompleto(Long id) {
        return null;
    }

    private List<InformacoesItensPedidoDTO> items(List<ItemPedido> itens) {

    }
}
