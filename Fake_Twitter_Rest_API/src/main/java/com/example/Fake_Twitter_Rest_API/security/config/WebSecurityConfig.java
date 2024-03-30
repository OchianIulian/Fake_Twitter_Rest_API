package com.example.Fake_Twitter_Rest_API.security.config;
import com.example.Fake_Twitter_Rest_API.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Arrays;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig {

    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * This metthod allows register type endpoints to be accessed without login
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // Disable Cross-Site Request Forgery (CSRF) protection
                .csrf(csrf -> csrf.disable())

                // Authorize HTTP requests
                .authorizeHttpRequests(authorize -> authorize
                        // Allow all methods under "/register/" to be accessed without authentication
                        .requestMatchers("/registration/**")
                        .permitAll()
                        // Require authentication for any other request
                        .anyRequest().authenticated())
//                .formLogin(formLogin -> {
//                    formLogin.loginPage("/registration").permitAll();
//                });
        return http.build();
    }

    /**
     * AuthenticationManager este interfața principală în Spring Security
     * care gestionează procesul de autentificare a utilizatorilor
     * @param auth
     * @return
     * @throws Exception
     */
    @Bean
    AuthenticationManager authenticationManager(AuthenticationManagerBuilder auth) throws Exception {
        return new ProviderManager(Arrays.asList(daoAuthenticationProvider()));
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(userService);
        return provider;

    }

}
