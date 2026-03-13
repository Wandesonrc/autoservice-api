package com.autoservice.api.autoservice.service.converte;

import com.autoservice.api.autoservice.dto.ServicoDTO;
import com.autoservice.api.autoservice.model.Servico;
import com.autoservice.api.autoservice.service.ConverteTo;
import org.springframework.stereotype.Component;

@Component
public class ServicoConverte implements ConverteTo<ServicoDTO, Servico> {
    @Override
    public Servico converteToBack(ServicoDTO a) {
        if (a != null){
            Servico servico = new Servico();
            servico.setNome(a.getNome());
            servico.setDescricao(a.getDescricao());
            servico.setValor(a.getValor());
            return servico;
        }
        return null;
    }

    @Override
    public ServicoDTO converteToFront(Servico t) {
        if (t != null){
            ServicoDTO servico = new ServicoDTO();
            servico.setNome(t.getNome());
            servico.setDescricao(t.getDescricao());
            servico.setValor(t.getValor());
        }
        return null;
    }
}
