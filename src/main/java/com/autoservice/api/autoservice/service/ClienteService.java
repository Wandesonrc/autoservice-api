package com.autoservice.api.autoservice.service;

import com.autoservice.api.autoservice.dto.ClienteDTO;
import com.autoservice.api.autoservice.model.Cliente;

import java.util.List;

public interface ClienteService {
    public Cliente criarCliente(ClienteDTO dto);

    public Cliente buscarPorId(Long id);

    public  List<Cliente> listarClientes();
}
