package com.autoservice.api.autoservice.service.converte;

import com.autoservice.api.autoservice.dto.PagamentoDTO;
import com.autoservice.api.autoservice.enus.FormaPagamento;
import com.autoservice.api.autoservice.enus.StatusPagamento;
import com.autoservice.api.autoservice.model.Pagamento;
import com.autoservice.api.autoservice.service.ConverteTo;
import org.springframework.stereotype.Component;

@Component
public class PagamentoConverte implements ConverteTo<PagamentoDTO, Pagamento> {

    @Override
    public Pagamento converteToBack(PagamentoDTO a) {
        if (a != null) {

            Pagamento pagamento = new Pagamento();
            pagamento.setPedidoId(a.getPedidoId());
            pagamento.setDataPagamento(a.getDataPagamento());
            pagamento.setFormaPagamento(FormaPagamento.valueOf(a.getFormaPagamento()));
            pagamento.setValorPago(a.getValorPago());
            pagamento.setStatusPagamento(StatusPagamento.valueOf(a.getStatusPagamento()));
            return pagamento;
        }

        return null;
    }

    @Override
    public PagamentoDTO converteToFront(Pagamento t) {
        if (t != null){
            PagamentoDTO dto = new PagamentoDTO();
            dto.setId(t.getId());
            dto.setPedidoId(t.getPedidoId());
            dto.setFormaPagamento(t.getFormaPagamento().name());
            dto.setValorPago(t.getValorPago());
            dto.setDataPagamento(t.getDataPagamento());
            dto.setStatusPagamento(t.getStatusPagamento().name());
            return dto;

        }

        return null;
    }
}
