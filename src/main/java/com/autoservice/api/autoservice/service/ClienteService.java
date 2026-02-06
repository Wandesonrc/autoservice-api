package com.autoservice.api.autoservice.service;

import com.autoservice.api.autoservice.dto.ClienteDTO;
import com.autoservice.api.autoservice.model.Cliente;
import com.autoservice.api.autoservice.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente criarCliente(@Valid ClienteDTO dto){

        Cliente cliente = new Cliente();

        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        cliente.setTelefone(dto.getTelefone());

        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> buscarPorId(Long id){
        return clienteRepository.findById(id);
    }

    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }
}
