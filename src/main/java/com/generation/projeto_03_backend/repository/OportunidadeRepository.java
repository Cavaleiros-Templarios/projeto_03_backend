package com.generation.projeto_03_backend.repository;

<<<<<<< HEAD
=======
import java.math.BigDecimal;
>>>>>>> 445fe9132028e92b88aa1c8136c115268ba5f4be
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.projeto_03_backend.model.Oportunidade;

@Repository
public interface OportunidadeRepository extends JpaRepository<Oportunidade, Long>{

	List<Oportunidade> findAllByTituloContainingIgnoreCase(String titulo);
<<<<<<< HEAD
	
=======
	List<Oportunidade> findByValorGreaterThan(BigDecimal valor);
	List<Oportunidade> findByValorLessThan(BigDecimal valor);
>>>>>>> 445fe9132028e92b88aa1c8136c115268ba5f4be
}
