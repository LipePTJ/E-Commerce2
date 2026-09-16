package com.biolab.ecommerce.services;

import com.biolab.ecommerce.DTOs.ProdutoDTO;
import com.biolab.ecommerce.entities.Produto;
import com.biolab.ecommerce.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public String criar(ProdutoDTO dto) {
        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());
        produtoRepository.save(produto);
        return "Produto Criado com Sucesso!!";
    }

    public ProdutoDTO atualizar(Long id, ProdutoDTO dto) {
        Produto produto = produtoRepository.findById(id).orElseThrow();
        ProdutoDTO pdto = new ProdutoDTO();
        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());
        produtoRepository.save(produto);
        pdto.setId(produto.getId());
        pdto.setNome(produto.getNome());
        pdto.setPreco(produto.getPreco());
        return pdto;
    }

    public String deletar(Long id) {
        Produto produto = produtoRepository.findById(id).orElseThrow();
        produtoRepository.deleteById(produto.getId());
        return "excluido!";
    }

    public List<Produto> buscarTodos() {
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id).orElseThrow();
    }
}