package br.com.turorial.estudos.vendas.domain.rest.service.interfaces;

import br.com.turorial.estudos.vendas.domain.entity.Produto;
import br.com.turorial.estudos.vendas.domain.rest.dto.ProdutoDTO;

public interface ProdutoService {

    Produto salvar(ProdutoDTO dto);
    Produto pesquisarId(Long id);
}
