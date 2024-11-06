package br.com.cvcteste.teste.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cvcteste.teste.dto.ClienteDto;
import br.com.cvcteste.teste.entities.Cliente;
import br.com.cvcteste.teste.services.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/cliente")
@RequiredArgsConstructor
@Tag(name = "Controller do cliente", description = "Controller que faz as alterações nos dados dos clientes")
public class ClienteController {
	private final ClienteService clienteService;
	
	@GetMapping("/all")
	@Operation(description = "Busca todos os clientes cadastrados ordenado pelo nome")
	public List<Cliente> buscaTodos() {
		return clienteService.buscaTodos();
	}
	
	@GetMapping("{estado}")
	@Operation(description = "Busca todos os clientes do estado informado")
	public List<Cliente> buscaEstado(String estado) { 
		return clienteService.buscaEstado(estado); 
	}
	
	@PostMapping
	@Operation(description = "Inclui um cadastro de usuário")
	public void inserir(
			@Valid ClienteDto clienteDto) {
		clienteService.inserir(clienteDto);
	}
	
	@PatchMapping
	@Operation(description = "Altera um cadastro existente")
	public void alterar(@Valid ClienteDto clienteDto) {
		clienteService.atualizar(clienteDto);
	}
	
	@DeleteMapping("{id}")
	@Operation(description = "Remove um cadastro")
	public void excluir(Integer id) {
		clienteService.excluir(id);
	}
}
