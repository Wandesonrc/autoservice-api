package com.autoservice.api.autoservice.controller;

import com.autoservice.api.autoservice.dto.PagamentoDTO;
import com.autoservice.api.autoservice.model.Pagamento;
import com.autoservice.api.autoservice.service.PagamentoService;
import com.autoservice.api.autoservice.service.impl.PagamentoImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PagamentoController {
    @Autowired
    private PagamentoImpl pagamentoService;

    @PostMapping("/pagamento")
    public ResponseEntity<Pagamento>criarPagamento(@Valid @RequestBody PagamentoDTO dto){
        Pagamento pagamento = pagamentoService.criarPagamento(dto);
        return new ResponseEntity<>(pagamento, HttpStatus.CREATED);

    }
    @GetMapping("pagamentos")
    public List<Pagamento> listar(){
        return pagamentoService.listarPagamento();
    }
    @PatchMapping("/{id}/cancelar")
    public Pagamento canacelarPagamento(@PathVariable Long id) {
        return pagamentoService.cancelarPagamento(id);
    }
}
