package com.autoservice.api.autoservice.service.impl;

import com.autoservice.api.autoservice.model.ItemPedido;
import com.autoservice.api.autoservice.model.MovimentacaoEstoque;
import com.autoservice.api.autoservice.model.Pedido;
import com.autoservice.api.autoservice.repository.ItemPedidoRepository;
import com.autoservice.api.autoservice.repository.MovimentacaoEstoqueRepository;
import com.autoservice.api.autoservice.service.MovimentacaoEstoqueService;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimentacaoEstoqueImpl implements MovimentacaoEstoqueService {

    private final MovimentacaoEstoqueRepository repository;

    private final ItemPedidoRepository itemPedidoRepository;

    private final EntityManager entityManager;


    public MovimentacaoEstoqueImpl(MovimentacaoEstoqueRepository repository,
                                   ItemPedidoRepository itemPedidoRepository,
                                   EntityManager entityManager){
        this.repository = repository;
        this.itemPedidoRepository = itemPedidoRepository;
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public void registrarBaixaPorPedido(Pedido pedidoId) {
        List<ItemPedido> itens = itemPedidoRepository.findItensByPedido(pedidoId);

        for (ItemPedido item : itens){
            Long produtoId = item.getId();
            Integer quantidade = item.getQuantidade();

            // Salva movimentação
            MovimentacaoEstoque mov = new MovimentacaoEstoque(produtoId, quantidade, "SAIDA", "Pedido" + pedidoId);
            repository.save(mov);

            // Chama procedure para atualizar o estoque
            chamarProcedureMovimentacao(produtoId, quantidade, "SAIDA");
        }

    }

    @Override
    @Transactional
    public void registrarEntradaPorReposicao(Long produtoId, Integer quantidade, String referencia) {
        MovimentacaoEstoque mov = new MovimentacaoEstoque(produtoId, quantidade, "ENTRADA", referencia);
        repository.save(mov);

        chamarProcedureMovimentacao(produtoId, quantidade, "ENTRADA");

    }

    @Override
    public void chamarProcedureMovimentacao(Long produtoId, Integer quantidade, String tipoMovimentacao) {
        entityManager.createNativeQuery("CALL sp_atualizar_estoque(:produtoId, :quantidade, :tipo)")
                .setParameter("produtoId", produtoId)
                .setParameter("quantidade", quantidade)
                .setParameter("tipo", tipoMovimentacao)
                .executeUpdate();

    }

    public List<ItemPedido> findItensBypedido(Pedido pedidoId){
        return itemPedidoRepository.findItensByPedido(pedidoId);

    }
}
