package com.autoservice.api.autoservice.service;

import com.autoservice.api.autoservice.model.MovimentacaoEstoque;
import com.autoservice.api.autoservice.model.Pedido;
import jakarta.persistence.criteria.CriteriaBuilder;

public interface MovimentacaoEstoqueService {
    void registrarBaixaPorPedido(Pedido pedidoId);
    void registrarEntradaPorReposicao(Long produtoId, Integer quantidade, String referencia);
    void chamarProcedureMovimentacao(Long produtoId, Integer quantidade, String tipoMovimentacao);
}
