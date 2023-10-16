package com.spring_security_3.o.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;

import com.spring_security_3.o.serviceImpl.UserInfoUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {
	
	
	//ModelMapper configuration
	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	//authorization bean
	@Bean
	public UserDetailsService userDetailsService() {//PasswordEncoder encoder
		/* UserDetails admin=User.withUsername("user")
				 .password(encoder.encode("pwd1"))
				 .roles("ADMIN")
				 .build();
		 
		 UserDetails user=User.withUsername("auth")
				 .password(encoder.encode("pwd2"))
				 .roles("USER","ADMIN","HR")
				 .build();
		 return new InMemoryUserDetailsManager(admin,user);*/
		return new UserInfoUserDetailsService();
	}


    // Authentication bean
    @SuppressWarnings("removal")
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    	//https://docs.spring.io/spring-security/reference/migration-7/configuration.html#_use_the_lambda_dsl
		
		return http.csrf().disable()
				.authorizeHttpRequests().requestMatchers("/product/create","/dummy/new").permitAll()
				.and()
				.authorizeHttpRequests().requestMatchers("/product/**").authenticated()
				.and()
				.formLogin()
				.and()
				.build();
    	
    } 
	
	
	// Encoder bean
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}

}
