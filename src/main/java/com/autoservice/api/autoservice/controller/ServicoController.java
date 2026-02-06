package com.autoservice.api.autoservice.controller;

import com.autoservice.api.autoservice.dto.ServicoDTO;
import com.autoservice.api.autoservice.model.Servico;
import com.autoservice.api.autoservice.service.ServicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @PostMapping("/servico")
    public ResponseEntity<Servico> criarServico(@Valid ServicoDTO dto){
        Servico servico = servicoService.criarServico(dto);
        return new ResponseEntity<>(servico, HttpStatus.CREATED);
    }


}
