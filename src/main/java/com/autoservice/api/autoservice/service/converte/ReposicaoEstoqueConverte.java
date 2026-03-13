package com.autoservice.api.autoservice.service.converte;

import com.autoservice.api.autoservice.dto.ReposicaoEstoqueDTO;
import com.autoservice.api.autoservice.model.ReposicaoEstoque;
import com.autoservice.api.autoservice.service.ConverteTo;
import jakarta.persistence.Column;
import org.springframework.stereotype.Component;

@Component
public class ReposicaoEstoqueConverte implements ConverteTo<ReposicaoEstoqueDTO, ReposicaoEstoque> {


    @Override
    public ReposicaoEstoque converteToBack(ReposicaoEstoqueDTO a) {
        if (a != null ){
            ReposicaoEstoque reposicaoEstoque = new ReposicaoEstoque();
            reposicaoEstoque.setIdProduto(a.getIdProduto());
            reposicaoEstoque.setQuantidade(a.getQuantidade());
            reposicaoEstoque.setCustoUnitario(a.getCustoUnitario());
            reposicaoEstoque.setValorTotal(a.getValorTotal());
            reposicaoEstoque.setDescricao(a.getDescricao());
            reposicaoEstoque.setDataReposicao(a.getDataReposicao());
            reposicaoEstoque.setFornecedor(a.getFornecedor());
            return reposicaoEstoque;
        }
        return null;
    }

    @Override
    public ReposicaoEstoqueDTO converteToFront(ReposicaoEstoque t) {
        if (t != null){
            ReposicaoEstoqueDTO reposicaoEstoqueDTO = new ReposicaoEstoqueDTO();
            reposicaoEstoqueDTO.setId(t.getId());
            reposicaoEstoqueDTO.setIdProduto(t.getIdProduto());
            reposicaoEstoqueDTO.setQuantidade(t.getQuantidade());
            reposicaoEstoqueDTO.setCustoUnitario(t.getCustoUnitario());
            reposicaoEstoqueDTO.setValorTotal(t.getValorTotal());
            reposicaoEstoqueDTO.setDataReposicao(t.getDataReposicao());
            reposicaoEstoqueDTO.setFornecedor(t.getFornecedor());
            reposicaoEstoqueDTO.setDescricao(t.getDescricao());
            return reposicaoEstoqueDTO;
        }
        return null;
    }
}
