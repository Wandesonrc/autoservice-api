package com.autoservice.api.autoservice.service.impl;

import com.autoservice.api.autoservice.dto.ReposicaoEstoqueDTO;
import com.autoservice.api.autoservice.model.Produto;
import com.autoservice.api.autoservice.model.ReposicaoEstoque;
import com.autoservice.api.autoservice.repository.ReposicaoEstoqueRepository;
import com.autoservice.api.autoservice.service.ProdutoService;
import com.autoservice.api.autoservice.service.ReposicaoEstoqueService;
import com.autoservice.api.autoservice.service.converte.ReposicaoEstoqueConverte;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ReposicaoEstoqueImpl implements ReposicaoEstoqueService {

    private final ReposicaoEstoqueRepository repository;
    private final ProdutoService produtoService;
    private final ReposicaoEstoqueConverte converte;

    public ReposicaoEstoqueImpl(ReposicaoEstoqueRepository repository,
                                ProdutoService produtoService,
                                ReposicaoEstoqueConverte converte) {
        this.repository = repository;
        this.produtoService = produtoService;
        this.converte = converte;
    }

    @Override
    @Transactional
    public ReposicaoEstoque criarReposicao(ReposicaoEstoqueDTO dto) {
        //validaProduto(dto.getIdProduto());
        return repository.save(converte.converteToBack(dto));
    }

    @Override
    public ReposicaoEstoqueDTO reposicaoEstoqueConverte(ReposicaoEstoque reposicao) {
        return converte.converteToFront(reposicao);
    }

    private void validaProduto(Long idProduto) {
        produtoService.buscarPorId(idProduto);
    }
}
