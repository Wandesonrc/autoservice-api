package com.autoservice.api.autoservice.service;

import com.autoservice.api.autoservice.dto.ProdutoDTO;
import com.autoservice.api.autoservice.model.Produto;

import java.util.List;


public interface ProdutoService {
    public Produto criarProduto ( ProdutoDTO dto);

    public Produto buscarPorId(Long id);

    public List<Produto> listarProdutos();



}
