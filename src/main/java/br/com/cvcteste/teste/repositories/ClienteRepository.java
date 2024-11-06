package br.com.cvcteste.teste.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import br.com.cvcteste.teste.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	@Query(value = "select id, nome, email from cliente order by nome", nativeQuery = true)
	public List<Cliente> buscaTodos();
	
	@Query(value = "select c.id, c.nome, c.email from cliente c join endereco e on e.id = c.id where e.estado = :estado", nativeQuery = true)
	public List<Cliente> buscaPorEstado(String estado);
	
	@Modifying
	@Query(value = "insert into cliente(id, nome, email) values (:id, :nome, :email)", nativeQuery = true)
	public void inserir(Integer id, String nome, String email);
	
	@Modifying
	@Query(value = "update cliente set nome = :nome, email = :email where id = :id", nativeQuery = true)
	public int atualizar(Integer id, String nome, String email);
	
	@Modifying
	@Query(value = "delete from cliente where id = :id", nativeQuery = true)
	public void excluir(Integer id);
	
	@Query(value = "select nextval('cliente_id_seq')", nativeQuery = true)
	public Integer buscarNextId();
	
	
}
