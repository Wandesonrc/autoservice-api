package com.autoservice.api.autoservice.service;

import com.autoservice.api.autoservice.model.Produto;
import com.autoservice.api.autoservice.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Optional<Produto> buscarPorId(Long id){
        return produtoRepository.findById(id);
    }

    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }
}
