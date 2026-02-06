package com.autoservice.api.autoservice.service;

import com.autoservice.api.autoservice.dto.ServicoDTO;
import com.autoservice.api.autoservice.model.Servico;
import com.autoservice.api.autoservice.repository.ServicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {
    @Autowired
    private ServicoRepository servicoRepository;

    public Servico criarServico(@Valid ServicoDTO dto){

        Servico servico = new Servico();
        servico.setNome(dto.getNome());
        servico.setDescricao(dto.getDescricao());
        servico.setValor(dto.getValor());

        return servicoRepository.save(servico);
    }

    public Optional<Servico> buscarPorId(Long id){
        return servicoRepository.findById(id);
    }

    public List<Servico> listarServicos(){
        return servicoRepository.findAll();
    }
}
