package com.antonio.fp.retrato.seguridad;

import com.antonio.fp.retrato.modelo.Usuario;
import com.antonio.fp.retrato.repositorios.UserManagementRepository;
import com.antonio.fp.retrato.repositorios.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
    /*@Bean
    public UserDetailsService userDetailsService() {
        UserDetailsManager userDetailsManager =
                new InMemoryUserDetailsManager();
        userDetailsManager.createUser(
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build());
        userDetailsManager.createUser(
                User.withDefaultPasswordEncoder()
                        .username("admin")
                        .password("password")
                        .roles("ADMIN")
                        .build());
        return userDetailsManager;
    }*/
    @Bean
    UserDetailsService userService(UserRepository repo) {
        return username -> repo.findByUsername(username).asUser();
    }

    @Bean
    CommandLineRunner initUsers(UserManagementRepository repository) {
        return args -> {
            repository.save(new Usuario("user", "password", "ROLE_USER"));
            repository.save(new Usuario("admin", "password2", "ROLE_ADMIN"));
        };
    }

    /*@Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated();
        http.formLogin();
        http.httpBasic();
        return http.build();
    }*/
    @Bean
    SecurityFilterChain configureSecurity(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests() //
                .requestMatchers("/login").permitAll() //
                .requestMatchers("/", "/search").authenticated() //
                .requestMatchers(HttpMethod.GET, "/api/**")
                .authenticated() //
                .requestMatchers(HttpMethod.POST, "/new-video","/api/**").hasRole("ADMIN") //
                .anyRequest().denyAll() //
                .and() //
                .formLogin() //
                .and() //
                .httpBasic();
        return http.build();
    }

}
