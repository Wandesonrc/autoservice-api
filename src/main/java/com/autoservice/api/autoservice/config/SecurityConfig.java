package com.autoservice.api.autoservice.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // desativa proteção CSRF para facilitar testes
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/os").permitAll() // libera a rota de cliente
                        .anyRequest().authenticated() // outras rotas exigem autenticação
                );
        return http.build();
    }
}
