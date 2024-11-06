package br.com.cvcteste.teste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import br.com.cvcteste.teste.entities.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
	@Modifying
	@Query(value = "insert into endereco(id, rua, cidade, estado) values (:id, :rua, :cidade, :estado)", nativeQuery = true)
	public void inserir(Integer id, String rua, String cidade, String estado);
	
	@Modifying
	@Query(value = "update endereco set rua = :rua, cidade = :cidade, estado = :estado where id = :id", nativeQuery = true)
	public int atualizar(Integer id, String rua, String cidade, String estado);
	
	@Modifying
	@Query(value = "delete from endereco where id = :id", nativeQuery = true)
	public void excluir(Integer id);
}
