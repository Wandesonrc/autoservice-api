package com.autoservice.api.autoservice.service.impl;

import com.autoservice.api.autoservice.dto.ProdutoDTO;
import com.autoservice.api.autoservice.model.Produto;
import com.autoservice.api.autoservice.repository.ProdutoRepository;
import com.autoservice.api.autoservice.service.ProdutoService;
import com.autoservice.api.autoservice.service.converte.ProdutoConverte;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {

   private final ProdutoRepository repository;
   private final ProdutoConverte converte;

    public ProdutoServiceImpl(ProdutoRepository repository, ProdutoConverte converte) {
        this.repository = repository;
        this.converte = converte;
    }

    @Transactional
    @Override
    public Produto criarProduto(ProdutoDTO dto) {

        return repository.save(converte.converteToBack(dto));
    }

    @Override
    public Produto buscarPorId(Long id) {
        Optional <Produto> produto = repository.findById(id);
        if (produto.isEmpty()){
            throw new EntityNotFoundException("Produto não encontrado");
        }
        return produto.get();
    }

    @Override
    public List<Produto> listarProdutos() {
        return repository.findAll();
    }




}
