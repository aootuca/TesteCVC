package br.com.cvcteste.teste.config;

import java.util.List;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import br.com.cvcteste.teste.security.authentication.provider.CustomAuthenticationProvider;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {
/*	@Bean
	protected SecurityFilterChain securityFilterChain(HttpSecurity http, CustomBasicAuthFilter customBasicAuthFilter) throws Exception {
		http.authorizeHttpRequests(
				authorizeConfig -> {
					authorizeConfig.requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
						.anyRequest().authenticated();
				}
		)
		.sessionManagement((sessions) -> sessions.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.addFilterBefore(customBasicAuthFilter, BasicAuthenticationFilter.class)
		.csrf((csrf) -> csrf.disable());
		
		return http.build();
	}
*/
	private final CustomAuthenticationProvider customAuthenticationProvider;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((authorize) -> 
				authorize.requestMatchers(PathRequest.toH2Console()).permitAll()
				.anyRequest().authenticated()
			).headers(header -> 
				header.frameOptions(frameOption -> 
					frameOption.sameOrigin())
			).csrf(AbstractHttpConfigurer::disable)
		.formLogin(Customizer.withDefaults());

		return http.build();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
		AuthenticationManagerBuilder authBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
		authBuilder.authenticationProvider(customAuthenticationProvider);
		
		return authBuilder.build();
	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		final CorsConfiguration configuration = new CorsConfiguration();
		
//		configuration.setAllowedOrigins(ImmutableList.of("https://www.yourdomain.com")); // www - obligatory
      configuration.setAllowedOrigins(List.of("*"));  //set access from all domains
      configuration.setAllowedMethods(List.of("GET", "POST", "PATCH", "DELETE"));
      configuration.setAllowCredentials(true);
      configuration.setAllowedHeaders(List.of("Authorization", "Cache-Control", "Content-Type"));

      final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
      source.registerCorsConfiguration("/**", configuration);

      return source;
	}
/*	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
*/
}
