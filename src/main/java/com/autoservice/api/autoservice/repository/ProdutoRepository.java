package com.autoservice.api.autoservice.repository;

import com.autoservice.api.autoservice.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long> {
    Optional<Produto> findById(Long id);
}
