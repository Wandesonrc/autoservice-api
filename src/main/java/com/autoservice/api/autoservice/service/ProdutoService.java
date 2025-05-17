package com.autoservice.api.autoservice.service;

import com.autoservice.api.autoservice.dto.ProdutoDTO;
import com.autoservice.api.autoservice.model.Produto;
import com.autoservice.api.autoservice.repository.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto criarProduto (@Valid ProdutoDTO dto) {

        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setCategoria(dto.getCategoria());
        produto.setDescricao(dto.getDescricao());
        produto.setQuantidade(dto.getQuantidade());
        produto.setPrecoCompra(dto.getPrecoCompra());
        produto.setPrecoVenda(dto.getPrecoVenda());
        produto.setCategoria(dto.getCategoria());

        return produtoRepository.save(produto);
    }

    public Optional<Produto> buscarPorId(Long id){
        return produtoRepository.findById(id);
    }

    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }
}
