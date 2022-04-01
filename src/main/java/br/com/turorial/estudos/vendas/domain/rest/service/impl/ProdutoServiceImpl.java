package br.com.turorial.estudos.vendas.domain.rest.service.impl;

import br.com.turorial.estudos.vendas.domain.entity.Produto;
import br.com.turorial.estudos.vendas.domain.repository.ProdutoRepository;
import br.com.turorial.estudos.vendas.domain.rest.dto.ProdutoDTO;
import br.com.turorial.estudos.vendas.domain.rest.service.interfaces.ProdutoService;
import br.com.turorial.estudos.vendas.exception.RegraBadRequestException;
import br.com.turorial.estudos.vendas.exception.RegraNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Produto> pesquisar(Produto filtro) {
        ExampleMatcher exampleMatcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(filtro,exampleMatcher);

        return produtoRepository.findAll(example);
    }

    @Override
    public Produto deletar(Long id) {
        return produtoRepository.findById(id)
                .map(idEncontrado -> {
                    produtoRepository.deleteById(id);
                    return idEncontrado;
                }).orElseThrow(() ->
                        new RegraBadRequestException("Produto não encontrado"));
    }

    @Override
    public Produto update(Long id, Produto produto) {
        return produtoRepository.findById(id)
                .map(produtoEncontrado -> {
                    produto.setId(produtoEncontrado.getId());
                    produtoRepository.save(produto);
                    return produto;
                }).orElseThrow(() ->
                        new RegraNotFoundException("Produto não encontrado"));
    }
}
