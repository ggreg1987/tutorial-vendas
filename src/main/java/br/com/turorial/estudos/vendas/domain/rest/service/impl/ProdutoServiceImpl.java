package br.com.turorial.estudos.vendas.domain.rest.service.impl;

import br.com.turorial.estudos.vendas.domain.entity.Produto;
import br.com.turorial.estudos.vendas.domain.repository.ProdutoRepository;
import br.com.turorial.estudos.vendas.domain.rest.dto.ProdutoDTO;
import br.com.turorial.estudos.vendas.domain.rest.service.interfaces.ProdutoService;
import br.com.turorial.estudos.vendas.exception.RegraNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Override
    public Produto salvar(ProdutoDTO dto) {
        Produto produto = Produto
                .builder()
                .descricao(dto.getDescricao())
                .precoUnitario(dto.getPrecoUnitario())
                .build();
        return produtoRepository.save(produto);
    }

    @Override
    public Produto pesquisarId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() ->
                        new RegraNotFoundException("Produto não encontrado"));
    }
}
