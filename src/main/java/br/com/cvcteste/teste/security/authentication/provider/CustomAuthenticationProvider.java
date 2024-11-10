package br.com.cvcteste.teste.security.authentication.provider;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import br.com.cvcteste.teste.security.authentication.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	private final CustomUserDetailsService customUserDetailsService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String usuario = authentication.getName();
		String password = authentication.getCredentials().toString();
		
		var userDetails = customUserDetailsService.loadUserByUsername(usuario);
		
		return checkPassword(userDetails, password);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

	private Authentication checkPassword(UserDetails usuario, String password) {
		if (password.equals(usuario.getPassword())) {
			return new UsernamePasswordAuthenticationToken(usuario.getUsername(), password, usuario.getAuthorities());
		} else {
			throw new BadCredentialsException("Password Inválido.");
		}
	}
}
