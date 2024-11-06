package br.com.cvcteste.teste.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.cvcteste.teste.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	@Query(value = "select id, nome, email, usuario_criador, usuario_alteracao, data_criada, data_alterada from cliente order by nome", nativeQuery = true)
	public List<Cliente> buscaTodos();
	
	@Query(value = "select c.id, c.nome, c.email, c.usuario_criador, c.usuario_alteracao, c.data_criada, c.data_alterada from cliente c join endereco e on e.id = c.id where e.estado = :estado", nativeQuery = true)
	public List<Cliente> buscaPorEstado(String estado);
	
	@Modifying
	@Query(value = "insert into cliente(id, nome, email, usuario_criador, data_criada) "
			+ "values (:#{#cliente.id}, :#{#cliente.nome}, :#{#cliente.email}, :#{#cliente.usuarioCriador}, :#{#cliente.dataCriada})", nativeQuery = true)
	public void inserir(@Param("cliente") Cliente cliente);
	
	@Modifying
	@Query(value = "update cliente set nome = :#{#cliente.nome}, email = :#{#cliente.email}, usuario_alteracao = :#{#cliente.usuarioAlteracao}, data_alterada = :#{#cliente.dataAlterada} where id = :#{#cliente.id}", nativeQuery = true)
	public int atualizar(@Param("cliente") Cliente cliente);
	
	@Modifying
	@Query(value = "delete from cliente where id = :id", nativeQuery = true)
	public void excluir(Integer id);
	
	@Query(value = "select nextval('cliente_id_seq')", nativeQuery = true)
	public Integer buscarNextId();
	
	
}
