package com.autoservice.api.autoservice.service.impl;

import com.autoservice.api.autoservice.dto.ClienteDTO;
import com.autoservice.api.autoservice.model.Cliente;
import com.autoservice.api.autoservice.repository.ClienteRepository;
import com.autoservice.api.autoservice.service.ClienteService;
import com.autoservice.api.autoservice.service.converte.ClienteConverte;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository repository;
    private final ClienteConverte converte;

    public ClienteServiceImpl(ClienteRepository repository, ClienteConverte converte) {
        this.repository = repository;
        this.converte = converte;
    }

    @Transactional
    @Override
    public Cliente criarCliente(ClienteDTO dto) {
        return repository.save(converte.converteToBack(dto));
    }

    @Override
    public Cliente buscarPorId(Long id) {
        Optional<Cliente> cliente = repository.findById(id);
        if (cliente.isEmpty()){
            throw new EntityNotFoundException("Cliente não encontrado");
        }
        return cliente.get();
    }

    @Override
    public List<Cliente> listarClientes() {
        return repository.findAll();
    }
}
