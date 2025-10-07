package com.autoservice.api.autoservice.dto;

import com.autoservice.api.autoservice.model.ItemOrdemServico;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class OrdemServicoDTO {

    private Long id;

    private Long clienteId;

    private LocalDate dataAbertura;

    private String status;

    private BigDecimal valorTotal;

    private List<ItemOrdemServicoDTO> itens;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }


    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ItemOrdemServicoDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItemOrdemServicoDTO> itens) {
        this.itens = itens;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}
