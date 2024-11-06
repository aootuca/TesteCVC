package br.com.cvcteste.teste.dto;

import jakarta.validation.constraints.Size;

public interface ClienteDto {
	Integer getId();
	@Size(max = 50, message = "Tamanho máximo excedido.")
	String getNome();
	@Size(max = 50, message = "Tamanho máximo excedido.")
	String getEmail();
	@Size(max = 50, message = "Tamanho máximo excedido.")
	String getRua();
	@Size(max = 50, message = "Tamanho máximo excedido.")
	String getCidade();
	@Size(max = 2, message = "Tamanho máximo excedido.")
	String getEstado();
}
