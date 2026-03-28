package com.autoservice.api.autoservice.controller;

import com.autoservice.api.autoservice.dto.FornecedorDTO;
import com.autoservice.api.autoservice.model.Fornecedor;
import com.autoservice.api.autoservice.service.impl.FornecedorImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FornecedorController {
    @Autowired
    FornecedorImpl fornecedorSevice;

    @PostMapping("/fornecedor")
    public ResponseEntity<Fornecedor> criarFornecedor(@Valid @RequestBody FornecedorDTO dto){
        Fornecedor fornecedor = fornecedorSevice.criarFornecedor(dto);
        return new ResponseEntity<>(fornecedor, HttpStatus.CREATED);
    }

    @GetMapping("/fornecedores")
    public List<Fornecedor> listar(){
        return fornecedorSevice.listarFornecedores();
    }

}
