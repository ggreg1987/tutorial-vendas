package br.com.turorial.estudos.vendas.domain.rest.service.interfaces;

import br.com.turorial.estudos.vendas.domain.rest.dto.InformacoesPedidoDTO;

public interface InformacaoPedidoService {

    InformacoesPedidoDTO informacaoPedidoCompleto(Long id);
}
