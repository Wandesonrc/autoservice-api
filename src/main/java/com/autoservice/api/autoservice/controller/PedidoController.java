package com.autoservice.api.autoservice.controller;

import com.autoservice.api.autoservice.dto.PedidoDTO;
import com.autoservice.api.autoservice.model.Pedido;
import com.autoservice.api.autoservice.service.impl.PedidoServiceimpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PedidoController {
    @Autowired
    private PedidoServiceimpl sevice;

    @PostMapping("/pedido")
    public ResponseEntity<PedidoDTO>criarPedido(@Valid @RequestBody PedidoDTO dto){
        Pedido pedido = sevice.criarPedido(dto);
        PedidoDTO repost = sevice.pedidoConverte(pedido);
        return new ResponseEntity<>(repost, HttpStatus.CREATED);
    }
}
