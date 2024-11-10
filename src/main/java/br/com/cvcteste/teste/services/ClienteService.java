package br.com.cvcteste.teste.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.cvcteste.teste.dto.ClienteDto;
import br.com.cvcteste.teste.entities.Cliente;
import br.com.cvcteste.teste.repositories.ClienteRepository;
import br.com.cvcteste.teste.repositories.EnderecoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {
	private final ClienteRepository clienteRepository;
	private final EnderecoRepository enderecoRepository; 

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Cliente> buscaTodos() {
		return clienteRepository.buscaTodos();
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Cliente> buscaEstado(String estado) {
		return clienteRepository.buscaPorEstado(estado);
	}
	
    @Transactional(propagation = Propagation.REQUIRED)
	public void inserir(ClienteDto clienteDto, String username) {
    	Integer nextId = clienteRepository.buscarNextId();
    	
    	Cliente cliente = new Cliente();
    	cliente.setId(nextId);
    	cliente.setNome(clienteDto.getNome());
    	cliente.setEmail(clienteDto.getEmail());
    	cliente.setUsuarioCriador(username);
    	cliente.setDataCriada(LocalDateTime.now());
    	
    	clienteRepository.inserir(cliente);
    	enderecoRepository.inserir(nextId, clienteDto.getRua(), clienteDto.getCidade(), clienteDto.getEstado());
	}

    @Transactional(propagation = Propagation.REQUIRED)	
    public void atualizar(ClienteDto clienteDto, String username) {
    	Cliente cliente = new Cliente();
    	cliente.setId(clienteDto.getId());
    	cliente.setNome(clienteDto.getNome());
    	cliente.setEmail(clienteDto.getEmail());
    	cliente.setUsuarioAlteracao(username);
    	cliente.setDataAlterada(LocalDateTime.now());
    	
    	clienteRepository.atualizar(cliente);
    	enderecoRepository.atualizar(clienteDto.getId(), clienteDto.getRua(), clienteDto.getCidade(), clienteDto.getEstado());
	}

    @Transactional(propagation = Propagation.REQUIRED)
	public void excluir(Integer id) {
    	enderecoRepository.excluir(id);
    	clienteRepository.excluir(id);
		
	}
	
	
}
