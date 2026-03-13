package com.autoservice.api.autoservice.service.converte;

import com.autoservice.api.autoservice.dto.ProdutoDTO;
import com.autoservice.api.autoservice.model.Produto;
import com.autoservice.api.autoservice.service.ConverteTo;
import org.springframework.stereotype.Component;

@Component
public class ProdutoConverte implements ConverteTo <ProdutoDTO, Produto> {
    @Override
    public Produto converteToBack(ProdutoDTO a) {
        if (a != null ){
            Produto produto = new Produto();
            produto.setNome(a.getNome());
            produto.setDescricao(a.getDescricao());
            produto.setQuantidade_estoque(a.getQuantidade());
            produto.setPrecoVenda(a.getPrecoVenda());
            produto.setPrecoCompra(a.getPrecoCompra());
            produto.setCategoria(a.getCategoria());
            return produto;

        }
        return null;
    }

    @Override
    public ProdutoDTO converteToFront(Produto t) {
        if (t != null){
            ProdutoDTO produto = new ProdutoDTO();
            produto.setNome(t.getNome());
            produto.setDescricao(t.getDescricao());
            produto.setQuantidade(t.getQuantidade_estoque());
            produto.setPrecoCompra(t.getPrecoCompra());
            produto.setPrecoVenda(t.getPrecoVenda());
            produto.setCategoria(t.getCategoria());
            return produto;
        }
        return null;
    }
}
