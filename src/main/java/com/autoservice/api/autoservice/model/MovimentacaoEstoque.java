package com.autoservice.api.autoservice.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "TB_MOVIMENTACAO_ESTOQUE")
public class MovimentacaoEstoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "îd_produto")
    private Long idProduto;

    private Integer quantidade;

    private LocalDate data;

    private String referencia; //"OS-001" ou "REPOSICAO-123"

    private String tipoMovimentacao;


    public MovimentacaoEstoque(Long produtoId, Integer quantidade, String entrada, String referencia) {
    }

    public MovimentacaoEstoque(Long id, Long idProduto, Integer quantidade, Date data, String referencia, String responsavel, String tipoMovimentacao) {
        this.id = id;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.data = LocalDate.now();
        this.referencia = referencia;
        this.tipoMovimentacao = tipoMovimentacao;
    }

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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(String tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }
}
