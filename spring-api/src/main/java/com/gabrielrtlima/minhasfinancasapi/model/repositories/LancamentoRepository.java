package com.gabrielrtlima.minhasfinancasapi.model.repositories;

import com.gabrielrtlima.minhasfinancasapi.model.entities.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {
}
