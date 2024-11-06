package br.com.cvcteste.teste.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cvcteste.teste.dto.ClienteDto;
import br.com.cvcteste.teste.entities.Cliente;
import br.com.cvcteste.teste.services.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/cliente")
@RequiredArgsConstructor
public class ClienteController {
	private final ClienteService clienteService;
	
	@GetMapping("/all")
	public List<Cliente> buscaTodos() {
		return clienteService.buscaTodos();
	}
	
	@GetMapping("{estado}")
	public List<Cliente> buscaEstado(String estado) { 
		return clienteService.buscaEstado(estado); 
	}
	
	@PostMapping
	public void inserir(
			@Valid ClienteDto clienteDto) {
		clienteService.inserir(clienteDto);
	}
	
	@PatchMapping
	public void alterar(@Valid ClienteDto clienteDto) {
		clienteService.atualizar(clienteDto);
	}
	
	public void excluir(Integer id) {
		clienteService.excluir(id);
	}
}
