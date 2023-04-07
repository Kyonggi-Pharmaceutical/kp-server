package kr.ac.kgu.kpserver.config;

import kr.ac.kgu.kpserver.security.CustomAuthenticationFilter;
import kr.ac.kgu.kpserver.security.DummyAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CustomAuthenticationFilter customAuthenticationFilter;
    private final DummyAuthenticationFilter dummyAuthenticationFilter;

    public SecurityConfig(CustomAuthenticationFilter customAuthenticationFilter, DummyAuthenticationFilter dummyAuthenticationFilter) {
        this.customAuthenticationFilter = customAuthenticationFilter;
        this.dummyAuthenticationFilter = dummyAuthenticationFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .cors()
        ;
        http
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        ;
        http
                .addFilterBefore(customAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(dummyAuthenticationFilter, CustomAuthenticationFilter.class)
                .authorizeHttpRequests()
                .antMatchers("/api/v1/login/**", "/h2-console/**", "/test/**", "/swagger-ui/**", "/v3/api-docs/**").permitAll()
                .anyRequest().authenticated()
        ;
        http
                .headers().frameOptions().disable()
        ;
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        return authentication -> {
            throw new AuthenticationServiceException("Spring security auto-configuration for AuthenticationManager: DISABLED");
        };
    }
}
