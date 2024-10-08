package com.projeto_dsc.Companhia_Area.infra_security;

import org.springframework.beans.factory.annotation.Autowired;
import org.aspectj.apache.bcel.classfile.ExceptionTable;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.projeto_dsc.Companhia_Area.infra_security.SecurityFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {

	@Autowired
    SecurityFilter securityFilter;

	@Autowired
	CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
		return httpSecurity
			.csrf(csrf -> csrf.disable())
			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.authorizeHttpRequests(authorize -> authorize
					.requestMatchers(HttpMethod.GET, "/login").permitAll()
					.requestMatchers(HttpMethod.POST, "/login").permitAll()
					.requestMatchers(HttpMethod.GET, "/cadastro").permitAll()
					.requestMatchers(HttpMethod.POST, "/usuario").permitAll()
					.requestMatchers("/css/**", "/js/**", "/images/**").permitAll()
					.anyRequest().authenticated()
			)
			.exceptionHandling(exception -> exception
					.authenticationEntryPoint(customAuthenticationEntryPoint)
			)
			.addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
			.build();
	}
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
}