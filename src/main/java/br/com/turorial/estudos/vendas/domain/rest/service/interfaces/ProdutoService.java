package br.com.turorial.estudos.vendas.domain.rest.service.interfaces;

import br.com.turorial.estudos.vendas.domain.entity.Produto;
import br.com.turorial.estudos.vendas.domain.rest.dto.ProdutoDTO;

import java.util.List;

public interface ProdutoService {

    Produto salvar(ProdutoDTO dto);
    Produto pesquisarId(Long id);
    List<Produto> pesquisar(Produto filtro);
}
