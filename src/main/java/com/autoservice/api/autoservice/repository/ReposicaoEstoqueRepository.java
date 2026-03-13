package com.autoservice.api.autoservice.repository;

import com.autoservice.api.autoservice.model.ReposicaoEstoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReposicaoEstoqueRepository extends JpaRepository<ReposicaoEstoque, Long> {
}
