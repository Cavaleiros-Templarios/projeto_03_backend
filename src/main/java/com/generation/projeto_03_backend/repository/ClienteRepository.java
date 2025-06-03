package com.generation.projeto_03_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.projeto_03_backend.model.Cliente;

public interface ClienteRepository  extends JpaRepository<Cliente, Long>{

	List<Cliente> findAllByNomeContainingIgnoreCase(String nome);
	
}
