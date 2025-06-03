package com.generation.projeto_03_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.projeto_03_backend.model.Oportunidade;

public interface OportunidadeRepository extends JpaRepository<Oportunidade, Long>{

	List<Oportunidade> findAllByTituloContainingIgnoreCase(String titulo);
	
}
