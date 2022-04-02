package br.com.turorial.estudos.vendas.domain.rest.service.impl;

import br.com.turorial.estudos.vendas.domain.entity.Pedido;
import br.com.turorial.estudos.vendas.domain.rest.dto.PedidoDTO;
import br.com.turorial.estudos.vendas.domain.rest.service.interfaces.PedidoService;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {

    
    @Override
    public Pedido salvar(PedidoDTO dto) {
        return null;
    }
}
