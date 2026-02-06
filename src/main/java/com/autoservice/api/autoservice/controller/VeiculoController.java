package com.autoservice.api.autoservice.controller;

import com.autoservice.api.autoservice.dto.VeiculoDTO;
import com.autoservice.api.autoservice.model.Veiculo;
import com.autoservice.api.autoservice.service.VeiculoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class VeiculoController {
    @Autowired
    private VeiculoService veiculoService;

    @PostMapping("/veiculo")
    public ResponseEntity<Veiculo> criarCliente(@Valid VeiculoDTO dto){
        Veiculo veiculo = veiculoService.criarVeiculo(dto);
       return new ResponseEntity<>(veiculo, HttpStatus.CREATED);

    }
}
