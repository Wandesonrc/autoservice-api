package com.autoservice.api.autoservice.repository;

import com.autoservice.api.autoservice.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento,Long> {
    List<Pagamento> findByPedidoId(Long pedidoId);

    @Query("SELECT COALESCE(SUM(p.valorPago), 0) FROM Pagamento p WHERE p.dataPagamento >= :inicio AND p.dataPagamento <= :fim AND p.statusPagamento = 'CONFIRMADO'")
    BigDecimal sumFaturamentoPeriodo(@Param("inicio") LocalDateTime inicio, @Param("fim") LocalDateTime fim);
}
