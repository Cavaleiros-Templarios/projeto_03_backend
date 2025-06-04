package com.generation.projeto_03_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.projeto_03_backend.model.Cliente;

@Repository
public interface ClienteRepository  extends JpaRepository<Cliente, Long>{

	List<Cliente> findAllByNomeContainingIgnoreCase(String nome);
	
}
