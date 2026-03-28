package com.autoservice.api.autoservice.service.converte;

import com.autoservice.api.autoservice.dto.FornecedorDTO;
import com.autoservice.api.autoservice.model.Fornecedor;
import com.autoservice.api.autoservice.service.ConverteTo;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class FornecedorConverte implements ConverteTo<FornecedorDTO, Fornecedor> {
    @Override
    public Fornecedor converteToBack(FornecedorDTO a) {
        if (a != null){
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setNome(a.getNome());
            fornecedor.setCnpj(a.getCnpj());
            fornecedor.setEmail(a.getEmail());
            fornecedor.setTelefone(a.getTelefone());
            fornecedor.setCategoria(a.getCategoria());
            fornecedor.setSite(a.getSite());
            fornecedor.setDataCadastro(LocalDateTime.now());
            fornecedor.setStatus("ativo");
            fornecedor.setPrazoEntrega(a.getPrazoEntrega());
            return fornecedor;
        }
        return null;
    }

    @Override
    public FornecedorDTO converteToFront(Fornecedor t) {
        if (t != null){
            FornecedorDTO fornecedor = new FornecedorDTO();
            fornecedor.setId(t.getId());
            fornecedor.setNome(t.getNome());
            fornecedor.setCnpj(t.getCnpj());
            fornecedor.setEmail(t.getEmail());
            fornecedor.setEndereco(t.getEndereco());
            fornecedor.setTelefone(t.getTelefone());
            fornecedor.setCategoria(t.getCategoria());
            fornecedor.setDataCadastro(t.getDataCadastro());
            fornecedor.setSite(t.getSite());
            fornecedor.setStatus(t.getStatus());
            fornecedor.setPrazoEntrega(t.getPrazoEntrega());

        }
        return null;
    }
}
