package com.vikrant.org.microserviceslab2rest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class CustomSpringSecurity {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
       
        httpSecurity.authorizeHttpRequests(
            auth -> auth.anyRequest().authenticated()
        ); 
        httpSecurity.httpBasic(Customizer.withDefaults());
        httpSecurity.csrf().disable(); 
        return httpSecurity.build();
    }
    
}
