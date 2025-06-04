package com.generation.projeto_03_backend.controller;

<<<<<<< HEAD
=======
import java.math.BigDecimal;
>>>>>>> 445fe9132028e92b88aa1c8136c115268ba5f4be
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.projeto_03_backend.model.Oportunidade;
import com.generation.projeto_03_backend.repository.ClienteRepository;
import com.generation.projeto_03_backend.repository.OportunidadeRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/oportunidades")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OportunidadeController {
	
	Set<String> statusValidos = Set.of("aberta", "fechada", "perdida");

    @Autowired
    private OportunidadeRepository oportunidadeRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public ResponseEntity<List<Oportunidade>> getAll() {
        return ResponseEntity.ok(oportunidadeRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Oportunidade> getById(@PathVariable Long id) {
        return oportunidadeRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<Oportunidade>> getByTitulo(@PathVariable String titulo) {
        return ResponseEntity.ok(oportunidadeRepository.findAllByTituloContainingIgnoreCase(titulo));
    }
<<<<<<< HEAD
=======
    
    @GetMapping("/oportunidade/maiorque/{valor}")
    public ResponseEntity<List<Oportunidade>> getByOportunidadeMaior(@PathVariable BigDecimal valor) {
        List<Oportunidade> oportunidades = oportunidadeRepository.findByValorGreaterThan(valor);
        return ResponseEntity.ok(oportunidades);
    }

    
    @GetMapping("/oportunidade/menorque/{valor}")
    public ResponseEntity<List<Oportunidade>> getByOportunidadeMenor(@PathVariable BigDecimal valor) {
        List<Oportunidade> oportunidades = oportunidadeRepository.findByValorLessThan(valor);
        return ResponseEntity.ok(oportunidades);
    }
>>>>>>> 445fe9132028e92b88aa1c8136c115268ba5f4be

    @PostMapping
    public ResponseEntity<Oportunidade> post(@Valid @RequestBody Oportunidade oportunidade) {
        if (clienteRepository.existsById(oportunidade.getCliente().getId()))
            return ResponseEntity.status(HttpStatus.CREATED).body(oportunidadeRepository.save(oportunidade));

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente não existe!", null);
    }

    @PutMapping
    public ResponseEntity<Oportunidade> put(@Valid @RequestBody Oportunidade oportunidade) {
        if (oportunidadeRepository.existsById(oportunidade.getId())) {

            if (clienteRepository.existsById(oportunidade.getCliente().getId()))
                return ResponseEntity.status(HttpStatus.OK).body(oportunidadeRepository.save(oportunidade));

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente não existe!", null);

        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Optional<Oportunidade> oportunidade = oportunidadeRepository.findById(id);

        if (oportunidade.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        oportunidadeRepository.deleteById(id);
    }

    @PutMapping("/{id}/status/{status}")
    public ResponseEntity<Oportunidade> mudarStatus(@PathVariable Long id, @PathVariable String status) {

//        if (!status.equalsIgnoreCase("aberta") || !status.equalsIgnoreCase("fechada") || !status.equalsIgnoreCase("perdida")) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O Status deve ser ABERTA, FECHADA ou PERDIDA");
//        }
    	if (status == null || !statusValidos.contains(status.trim().toLowerCase())) {
    	    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O Status deve ser ABERTA, FECHADA ou PERDIDA");
    	}

        Optional<Oportunidade> buscarOportunidade = oportunidadeRepository.findById(id);

        if (buscarOportunidade.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        Oportunidade oportunidade = buscarOportunidade.get();

        oportunidade.setStatus(String.valueOf(status));

        return ResponseEntity.status(HttpStatus.OK).body(oportunidadeRepository.save(oportunidade));
    }

}