package br.com.turorial.estudos.vendas.domain.rest.service.impl;

import br.com.turorial.estudos.vendas.domain.entity.Produto;
import br.com.turorial.estudos.vendas.domain.repository.ProdutoRepository;
import br.com.turorial.estudos.vendas.domain.rest.dto.ProdutoDTO;
import br.com.turorial.estudos.vendas.domain.rest.service.interfaces.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

}
