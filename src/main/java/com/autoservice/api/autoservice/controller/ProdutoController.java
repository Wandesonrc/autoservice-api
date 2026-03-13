package com.autoservice.api.autoservice.controller;

import com.autoservice.api.autoservice.dto.ProdutoDTO;
import com.autoservice.api.autoservice.model.Produto;
import com.autoservice.api.autoservice.service.impl.ProdutoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class ProdutoController {

    @Autowired
    private ProdutoServiceImpl produtoService;

    @PostMapping("/produto")
    public ResponseEntity<Produto> criarProduto(@Valid @RequestBody ProdutoDTO dto){
        Produto produto = produtoService.criarProduto(dto);
        return new ResponseEntity<>(produto, HttpStatus.CREATED);
    }


}
