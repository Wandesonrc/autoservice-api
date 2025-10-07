package com.autoservice.api.autoservice.controller;

import com.autoservice.api.autoservice.dto.OrdemServicoDTO;
import com.autoservice.api.autoservice.model.OrdemServico;
import com.autoservice.api.autoservice.service.impl.OrdemServicoServiceimpl;
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
public class OrdemServicoController {
    @Autowired
    private OrdemServicoServiceimpl sevice;

    @PostMapping("/os")
    public ResponseEntity<OrdemServicoDTO>criarOs(@Valid @RequestBody OrdemServicoDTO dto){
        OrdemServico ordemServico = sevice.criarOrdemServico(dto);
        OrdemServicoDTO repost = sevice.ordemServicoConverte(ordemServico);
        return new ResponseEntity<>(repost, HttpStatus.CREATED);
    }
}
