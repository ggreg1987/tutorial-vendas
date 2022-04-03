package br.com.turorial.estudos.vendas.domain.rest.service.interfaces;

import br.com.turorial.estudos.vendas.domain.enums.StatusPedido;
import br.com.turorial.estudos.vendas.domain.rest.dto.InformacoesPedidoDTO;

public interface InformacaoPedidoService {

    InformacoesPedidoDTO informacaoPedidoCompleto(Long id);
    void atualizarStatus(Long id, StatusPedido status);
}
