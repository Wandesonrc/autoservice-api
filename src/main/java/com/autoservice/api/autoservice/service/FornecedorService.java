package com.autoservice.api.autoservice.service;

import com.autoservice.api.autoservice.dto.FornecedorDTO;
import com.autoservice.api.autoservice.model.Fornecedor;

import java.util.List;

public interface FornecedorService {
    public Fornecedor criarFornecedor(FornecedorDTO dto);
    public FornecedorDTO fornecedorConverte(Fornecedor fornecedor);
    public Fornecedor buscarPorId(Long id);
    public List<Fornecedor> listarFornecedores();
}
