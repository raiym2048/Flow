package kg.it_lab.backend.Flow.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

         http.csrf(Customizer.withDefaults())
                 .authorizeHttpRequests(authorize -> authorize
                         .requestMatchers("/hello").permitAll()
                         .requestMatchers("/admin/**").hasRole("ADMIN")
                         .requestMatchers("/manager/**").hasRole("MANAGER")
                         .requestMatchers("/anonymous/**").anonymous()
                 )
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().authenticated()
                )
                 .formLogin(Customizer.withDefaults());
        return http.build();
    }
}
