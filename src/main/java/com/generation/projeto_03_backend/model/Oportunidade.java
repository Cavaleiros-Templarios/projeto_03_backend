package com.generation.projeto_03_backend.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_oportunidades")
public class Oportunidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O Atributo Titulo é Obrigatório!")
	private String titulo;
	
	@NotBlank(message = "O Atributo Status é Obrigatório!")
	private String status;
	
    @NotNull(message = "O atributo valor é obrigatório!")
    @DecimalMin(value = "0.01", message = "O preço deve ser maior que zero.")
    private BigDecimal valor;
    
    @UpdateTimestamp
	private LocalDateTime data_abertura;
	
    @UpdateTimestamp
	private LocalDateTime data_fechamento;

	@ManyToOne
	@JsonIgnoreProperties("oportunidade")
	private Cliente cliente;

	@ManyToOne
	@JsonIgnoreProperties("oportunidade")
	private Usuario usuario;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDateTime getData_abertura() {
		return data_abertura;
	}

	public void setData_abertura(LocalDateTime data_abertura) {
		this.data_abertura = data_abertura;
	}

	public LocalDateTime getData_fechamento() {
		return data_fechamento;
	}

	public void setData_fechamento(LocalDateTime data_fechamento) {
		this.data_fechamento = data_fechamento;
	}
	
	
	
}
