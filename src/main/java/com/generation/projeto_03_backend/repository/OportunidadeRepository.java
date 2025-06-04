package com.generation.projeto_03_backend.repository;

import java.math.BigDecimal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.projeto_03_backend.model.Oportunidade;

@Repository
public interface OportunidadeRepository extends JpaRepository<Oportunidade, Long>{

	List<Oportunidade> findAllByTituloContainingIgnoreCase(String titulo);
	List<Oportunidade> findByValorGreaterThan(BigDecimal valor);
	List<Oportunidade> findByValorLessThan(BigDecimal valor);

}
