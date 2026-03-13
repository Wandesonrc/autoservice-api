package com.autoservice.api.autoservice.service.impl;

import com.autoservice.api.autoservice.dto.ServicoDTO;
import com.autoservice.api.autoservice.model.Servico;
import com.autoservice.api.autoservice.repository.ServicoRepository;
import com.autoservice.api.autoservice.service.ServicoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoServiceImpl implements ServicoService {

    private final ServicoRepository repository;

    public ServicoServiceImpl(ServicoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Servico criarServico(ServicoDTO dto) {
        return null;
    }

    @Override
    public Servico buscarPorId(Long id) {
        Optional<Servico> servico = repository.findById(id);
        if (servico.isEmpty()){
            throw new EntityNotFoundException("Serviço não encontrado");
        }
        return servico.get();
    }

    @Override
    public List<Servico> listarServico() {
        return repository.findAll();
    }
}
