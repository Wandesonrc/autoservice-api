package com.autoservice.api.autoservice.service.converte;

import com.autoservice.api.autoservice.dto.ItemOrdemServicoDTO;
import com.autoservice.api.autoservice.dto.OrdemServicoDTO;
import com.autoservice.api.autoservice.enus.StatusOrdemServico;
import com.autoservice.api.autoservice.enus.TipoItemOrdemServico;
import com.autoservice.api.autoservice.model.ItemOrdemServico;
import com.autoservice.api.autoservice.model.OrdemServico;
import com.autoservice.api.autoservice.service.ConverteTo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrdemServicoConverte implements ConverteTo<OrdemServicoDTO, OrdemServico> {
    @Override
    public OrdemServico converteToBack(OrdemServicoDTO a) {
        if (a != null){
            OrdemServico os = new OrdemServico();
            os.setIdCliente(a.getClienteId());
            os.setDataAbertura(a.getDataAbertura());
            os.setStatus(StatusOrdemServico.valueOf(a.getStatus())); //enum
            os.setValorTotal(a.getValorTotal());

            List<ItemOrdemServico> itens = new ArrayList<>();
            for (ItemOrdemServicoDTO itemDto : a.getItens()){
                ItemOrdemServico item = new ItemOrdemServico();
                item.setTipo(TipoItemOrdemServico.valueOf(itemDto.getTipoItem())); //enum
                item.setReferenciaId(itemDto.getReferenciaId());
                item.setQuantidade(itemDto.getQuantidade());
                item.setValorUnitario(itemDto.getValorUnitario());
                item.setValorTotal(itemDto.getValorTotal());
                item.setOrdemServico(os);
                itens.add(item);
            }
            os.setItens(itens);
            return os;
        }
        return null;
    }

    @Override
    public OrdemServicoDTO converteToFront(OrdemServico t) {
        if (t != null){
            OrdemServicoDTO os = new OrdemServicoDTO();
            os.setId(t.getId());
            os.setClienteId(t.getIdCliente());
            os.setDataAbertura(t.getDataAbertura());
            os.setStatus(t.getStatus().name());
            os.setValorTotal(t.getValorTotal());

            List<ItemOrdemServicoDTO> itensDTO = new ArrayList<>();
            for (ItemOrdemServico item :t.getItens()){
                ItemOrdemServicoDTO itemDTO = new ItemOrdemServicoDTO();
                itemDTO.setTipoItem(item.getTipo().name());
                itemDTO.setReferenciaId(item.getReferenciaId());
                itemDTO.setQuantidade(item.getQuantidade());
                itemDTO.setValorUnitario(item.getValorUnitario());
                itemDTO.setValorTotal(item.getValorTotal());
                itensDTO.add(itemDTO);
            }
            os.setItens(itensDTO);
            return os ;
        }
        return null;
    }
}
