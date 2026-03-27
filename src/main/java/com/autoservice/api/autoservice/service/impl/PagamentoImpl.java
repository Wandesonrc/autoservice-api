package com.autoservice.api.autoservice.service.impl;

import com.autoservice.api.autoservice.dto.PagamentoDTO;
import com.autoservice.api.autoservice.dto.PedidoDTO;
import com.autoservice.api.autoservice.model.Pagamento;
import com.autoservice.api.autoservice.model.Pedido;
import com.autoservice.api.autoservice.repository.PagamentoRepository;
import com.autoservice.api.autoservice.repository.PedidoRepository;
import com.autoservice.api.autoservice.service.PagamentoService;
import com.autoservice.api.autoservice.service.PedidoService;
import com.autoservice.api.autoservice.service.converte.PagamentoConverte;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class PagamentoImpl implements PagamentoService {

    public final PagamentoRepository repository;
    public final PagamentoConverte converte;
    public final PedidoService pedidoService;

    public PagamentoImpl(PagamentoRepository repository, PagamentoConverte converte, PedidoService pedidoService) {
        this.repository = repository;
        this.converte = converte;
        this.pedidoService = pedidoService;
    }


    @Transactional
    @Override
    public Pagamento criarPagamento(PagamentoDTO dto) {
        return repository.save(converte.converteToBack(dto));
    }

    @Override
    public PagamentoDTO pagamentoConverte(Pagamento pagamento) {
        return converte.converteToFront(pagamento);
    }

//    private void validaPedido(Long idPedido) {
//        pedidoService.buscarPorId(idPedido);
//    }
}
