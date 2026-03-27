package com.autoservice.api.autoservice.service.impl;

import com.autoservice.api.autoservice.dto.PedidoDTO;
import com.autoservice.api.autoservice.model.Pedido;
import com.autoservice.api.autoservice.repository.PedidoRepository;
import com.autoservice.api.autoservice.service.ClienteService;
import com.autoservice.api.autoservice.service.PedidoService;
import com.autoservice.api.autoservice.service.converte.PedidoConverte;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceimpl implements PedidoService {

    private final PedidoRepository repository;
    private final ClienteService clienteService;
    private final PedidoConverte convert;

    public PedidoServiceimpl(PedidoRepository repository,
                             ClienteService clienteService,
                             PedidoConverte converte) {
        this.repository = repository;
        this.clienteService = clienteService;
        this.convert = converte;
    }


    @Transactional
    @Override
    public Pedido criarPedido(PedidoDTO dto) {
        //validaCliente(dto.getClienteId());

        return repository.save(convert.converteToBack(dto));
    }

    @Override
    public PedidoDTO pedidoConverte(Pedido pedido) {
        return convert.converteToFront(pedido);
    }

    @Override
    public Pedido buscarPorId(Long id) {

        return null;
    }

    private void validaCliente(Long idCliente) {
        clienteService.buscarPorId(idCliente);
    }

}
