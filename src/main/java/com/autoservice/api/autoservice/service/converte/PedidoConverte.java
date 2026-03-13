package com.autoservice.api.autoservice.service.converte;

import com.autoservice.api.autoservice.dto.ItemPedidoDTO;
import com.autoservice.api.autoservice.dto.PedidoDTO;
import com.autoservice.api.autoservice.enus.StatusPedido;
import com.autoservice.api.autoservice.enus.TipoItemPedido;
import com.autoservice.api.autoservice.model.ItemPedido;
import com.autoservice.api.autoservice.model.Pedido;
import com.autoservice.api.autoservice.service.ConverteTo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PedidoConverte implements ConverteTo<PedidoDTO, Pedido> {
    @Override
    public Pedido converteToBack(PedidoDTO a) {
        if (a != null){
            Pedido pedido = new Pedido();
            pedido.setIdCliente(a.getClienteId());
            pedido.setDataAbertura(a.getDataAbertura());
            pedido.setStatus(StatusPedido.valueOf(a.getStatus())); //enum
            pedido.setValorTotal(a.getValorTotal());

            List<ItemPedido> itens = new ArrayList<>();
            for (ItemPedidoDTO itemDto : a.getItens()){
                ItemPedido item = new ItemPedido();
                item.setTipo(TipoItemPedido.valueOf(itemDto.getTipoItem())); //enum
                item.setReferenciaId(itemDto.getReferenciaId());
                item.setQuantidade(itemDto.getQuantidade());
                item.setValorUnitario(itemDto.getValorUnitario());
                item.setValorTotal(itemDto.getValorTotal());
                item.setPedido(pedido);
                itens.add(item);
            }
            pedido.setItens(itens);
            return pedido;
        }
        return null;
    }

    @Override
    public PedidoDTO converteToFront(Pedido t) {
        if (t != null){
            PedidoDTO dto = new PedidoDTO();
            dto.setId(t.getId());
            dto.setClienteId(t.getIdCliente());
            dto.setDataAbertura(t.getDataAbertura());
            dto.setStatus(t.getStatus().name());
            dto.setValorTotal(t.getValorTotal());

            List<ItemPedidoDTO> itensDTO = new ArrayList<>();
            for (ItemPedido item :t.getItens()){
                ItemPedidoDTO itemDTO = new ItemPedidoDTO();
                itemDTO.setTipoItem(item.getTipo().name());
                itemDTO.setReferenciaId(item.getReferenciaId());
                itemDTO.setQuantidade(item.getQuantidade());
                itemDTO.setValorUnitario(item.getValorUnitario());
                itemDTO.setValorTotal(item.getValorTotal());
                itensDTO.add(itemDTO);
            }
            dto.setItens(itensDTO);
            return dto ;
        }
        return null;
    }
}
