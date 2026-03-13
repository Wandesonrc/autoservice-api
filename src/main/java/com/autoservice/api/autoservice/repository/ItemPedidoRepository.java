package com.autoservice.api.autoservice.repository;

import com.autoservice.api.autoservice.model.ItemPedido;
import com.autoservice.api.autoservice.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
    List<ItemPedido> findItensByPedido(Pedido pedidoId);
}
