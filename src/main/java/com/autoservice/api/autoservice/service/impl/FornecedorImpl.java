package com.autoservice.api.autoservice.service.impl;

import com.autoservice.api.autoservice.dto.FornecedorDTO;
import com.autoservice.api.autoservice.model.Fornecedor;
import com.autoservice.api.autoservice.repository.FornecedorRepository;
import com.autoservice.api.autoservice.service.FornecedorService;
import com.autoservice.api.autoservice.service.converte.FornecedorConverte;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FornecedorImpl implements FornecedorService {
    private final FornecedorRepository repository;
    private final FornecedorConverte converte;
    private final FornecedorService fornecedorService;

    public FornecedorImpl(FornecedorRepository repository, FornecedorConverte converte, FornecedorService fornecedorService) {
        this.repository = repository;
        this.converte = converte;
        this.fornecedorService = fornecedorService;
    }


    @Transactional
    @Override
    public Fornecedor criarFornecedor(FornecedorDTO dto) {
        return repository.save(converte.converteToBack(dto));
    }

    @Override
    public FornecedorDTO fornecedorConverte(Fornecedor fornecedor) {
        return converte.converteToFront(fornecedor);
    }

    @Override
    public Fornecedor buscarPorId(Long id) {
        return null;
    }

    @Override
    public List<Fornecedor> listarFornecedores() {
        return repository.findAll();
    }
}
