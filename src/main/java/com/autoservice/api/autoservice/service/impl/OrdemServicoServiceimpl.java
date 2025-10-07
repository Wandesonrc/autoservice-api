package com.autoservice.api.autoservice.service.impl;

import com.autoservice.api.autoservice.dto.OrdemServicoDTO;
import com.autoservice.api.autoservice.model.OrdemServico;
import com.autoservice.api.autoservice.repository.OrdemServicoRepository;
import com.autoservice.api.autoservice.service.ClienteService;
import com.autoservice.api.autoservice.service.OrdemServicoService;
import com.autoservice.api.autoservice.service.converte.OrdemServicoConverte;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class OrdemServicoServiceimpl implements OrdemServicoService {

    private final OrdemServicoRepository repository;
    private final ClienteService clienteService;
    private final OrdemServicoConverte convert;

    public OrdemServicoServiceimpl(OrdemServicoRepository repository,
                                   ClienteService clienteService,
                                   OrdemServicoConverte converte) {
        this.repository = repository;
        this.clienteService = clienteService;
        this.convert = converte;
    }


    @Transactional
    @Override
    public OrdemServico criarOrdemServico(OrdemServicoDTO dto) {
        //validaCliente(dto.getClienteId());

        return repository.save(convert.converteToBack(dto));
    }

    @Override
    public OrdemServicoDTO ordemServicoConverte(OrdemServico os) {
        return convert.converteToFront(os);
    }

    private void validaCliente(Long idCliente) {
        clienteService.buscarPorId(idCliente);
    }

}
