package com.autoservice.api.autoservice.service;

import com.autoservice.api.autoservice.dto.VeiculoDTO;
import com.autoservice.api.autoservice.model.Veiculo;
import com.autoservice.api.autoservice.repository.ClienteRepository;
import com.autoservice.api.autoservice.repository.VeiculoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {
    @Autowired
    private VeiculoRepository veiculoRepository;

    public Veiculo criarVeiculo(@Valid VeiculoDTO dto){
        Veiculo veiculo = new Veiculo();

        veiculo.setCliente(dto.getCliente());
        veiculo.setPlaca(dto.getPlaca());
        veiculo.setModelo(dto.getModelo());
        veiculo.setMarca(dto.getMarca());
        veiculo.setAno(dto.getAno());

       return veiculoRepository.save(veiculo);
    }

    public Optional<Veiculo> buscarPorId(Long id){
        return veiculoRepository.findById(id);
    }

    public List<Veiculo> listarVeiculos(){
        return veiculoRepository.findAll();
    }
}
