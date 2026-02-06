package com.autoservice.api.autoservice.controller;

import com.autoservice.api.autoservice.dto.ClienteDTO;
import com.autoservice.api.autoservice.model.Cliente;
import com.autoservice.api.autoservice.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/cliente")
    public ResponseEntity<Cliente> criarCliente(@Valid ClienteDTO dto){
        Cliente cliente = clienteService.criarCliente(dto);
        return new ResponseEntity<>(cliente, HttpStatus.CREATED);

    }
}
