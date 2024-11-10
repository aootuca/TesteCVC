package br.com.cvcteste.teste.security.authentication.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.cvcteste.teste.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	private final UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		var usuario = usuarioRepository.findByUsuario(username);
		
		if (usuario == null) 
			throw new UsernameNotFoundException("Usuario não registrado");
		
		return User.withUsername(username).password(usuario.getPassword()).roles("ADMIN").build();
	}

}
