package com.autoservice.api.autoservice.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReposicaoEstoqueDTO {

    private Long id;

    private Long idProduto;

    private Integer quantidade;

    private BigDecimal custoUnitario;

    private BigDecimal valorTotal;

    private String descricao;

    private String fornecedor;

    private LocalDate dataReposicao;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getCustoUnitario() {
        return custoUnitario;
    }

    public void setCustoUnitario(BigDecimal custoUnitario) {
        this.custoUnitario = custoUnitario;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public LocalDate getDataReposicao() {
        return dataReposicao;
    }

    public void setDataReposicao(LocalDate dataReposicao) {
        this.dataReposicao = dataReposicao;
    }
}
