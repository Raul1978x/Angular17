package com.recursospropios.facturacion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
        @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf().disable()
                .authorizeRequests().anyRequest()
                .permitAll() // Controla quien puede acceder al index, en este caso todos
                .and().formLogin(
                        form-> form
                                .loginPage("/login")
                                .permitAll()
                                .successForwardUrl("/login/redilogin") // En caso de una autenticacion correcta redirige a "/thymeleaf/redilogin" que esta en LoginController
                ).logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .logoutSuccessUrl("/login") // A donde redirige cuando cierro sesion
                                .invalidateHttpSession(true)
                                .deleteCookies("JSESSIONID")
                                .permitAll()
                ).exceptionHandling()
                .accessDeniedPage("/login/accesoD");
        return http.build();
    }

}
