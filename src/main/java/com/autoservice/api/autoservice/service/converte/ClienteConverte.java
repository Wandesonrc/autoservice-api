package com.autoservice.api.autoservice.service.converte;

import com.autoservice.api.autoservice.dto.ClienteDTO;
import com.autoservice.api.autoservice.model.Cliente;
import com.autoservice.api.autoservice.model.Produto;
import com.autoservice.api.autoservice.service.ConverteTo;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ClienteConverte implements ConverteTo <ClienteDTO, Cliente> {
    @Override
    public Cliente converteToBack(ClienteDTO a) {
        if (a != null){
            Cliente cliente = new Cliente();
            cliente.setNome(a.getNome());
            cliente.setTelefone(a.getTelefone());
            cliente.setDataCadastro(LocalDate.now());
            cliente.setEmail(a.getEmail());
            return cliente;
        }
        return null;
    }

    @Override
    public ClienteDTO converteToFront(Cliente t) {
        if (t != null){
            ClienteDTO cliente = new ClienteDTO();
            cliente.setNome(t.getNome());
            cliente.setTelefone(t.getTelefone());
            cliente.setEmail(t.getEmail());
            return cliente;
        }
        return null;
    }
}
