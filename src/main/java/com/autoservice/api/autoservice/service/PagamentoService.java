package com.autoservice.api.autoservice.service;

import com.autoservice.api.autoservice.dto.PagamentoDTO;
import com.autoservice.api.autoservice.dto.PedidoDTO;
import com.autoservice.api.autoservice.model.Pagamento;
import com.autoservice.api.autoservice.model.Pedido;

import java.util.List;

public interface PagamentoService {
    public Pagamento criarPagamento(PagamentoDTO dto);
    public PagamentoDTO pagamentoConverte (Pagamento pagamento);
    public List<Pagamento>listarPagamento();
    public Pagamento busrcarPagamento(Long id);
    public Pagamento cancelarPagamento(Long id);

}
