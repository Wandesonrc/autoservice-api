package com.autoservice.api.autoservice.service;

import com.autoservice.api.autoservice.dto.ReposicaoEstoqueDTO;
import com.autoservice.api.autoservice.model.ReposicaoEstoque;
import org.springframework.stereotype.Service;


public interface ReposicaoEstoqueService {
    public ReposicaoEstoque criarReposicao(ReposicaoEstoqueDTO dto);
    public ReposicaoEstoqueDTO reposicaoEstoqueConverte(ReposicaoEstoque reposicao);
}
