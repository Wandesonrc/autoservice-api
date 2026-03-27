package com.autoservice.api.autoservice.service;

import com.autoservice.api.autoservice.dto.PedidoDTO;
import com.autoservice.api.autoservice.model.Cliente;
import com.autoservice.api.autoservice.model.Pedido;
import org.springframework.stereotype.Service;

@Service
public interface PedidoService {
    public Pedido criarPedido(PedidoDTO dto);
    public PedidoDTO pedidoConverte (Pedido pedido);
    public Pedido buscarPorId(Long id);

}
