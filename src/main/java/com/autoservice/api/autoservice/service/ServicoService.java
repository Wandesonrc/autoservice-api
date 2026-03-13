package com.autoservice.api.autoservice.service;

import com.autoservice.api.autoservice.dto.ProdutoDTO;
import com.autoservice.api.autoservice.dto.ServicoDTO;
import com.autoservice.api.autoservice.model.Produto;
import com.autoservice.api.autoservice.model.Servico;

import java.util.List;

public interface ServicoService {
    public Servico criarServico (ServicoDTO dto);

    public Servico buscarPorId(Long id);

    public List<Servico> listarServico();

}
