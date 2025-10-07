package com.autoservice.api.autoservice.service;

import com.autoservice.api.autoservice.dto.OrdemServicoDTO;
import com.autoservice.api.autoservice.model.OrdemServico;
import org.springframework.stereotype.Service;

@Service
public interface OrdemServicoService {
    public OrdemServico criarOrdemServico(OrdemServicoDTO dto);
    public OrdemServicoDTO ordemServicoConverte (OrdemServico os);

}
