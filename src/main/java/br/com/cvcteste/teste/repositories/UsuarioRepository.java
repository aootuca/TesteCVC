package br.com.cvcteste.teste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.cvcteste.teste.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	@Query(value = "SELECT COUNT(*) > 0 FROM usuario WHERE usuario = :usuario and password = :password", nativeQuery = true)
	boolean existsData(String usuario, String password);

	@Query(value = "Select id, usuario, password FROM usuario WHERE usuario = :usuario", nativeQuery = true)
	Usuario findByUsuario(String usuario);
}
