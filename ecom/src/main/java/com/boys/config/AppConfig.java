package com.boys.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import jakarta.servlet.http.HttpServletRequest;

@Configuration 
public class AppConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{


        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
        .authorizeHttpRequests(Authorize->Authorize.requestMatchers("/api/**").authenticated().anyRequest().permitAll())
        .addFilterBefore(null, null).csrf().disable()
        .cors().configurationSource(new CorsConfigurationSource(){

            @Override
            @Nullable
            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
               CorsConfiguration cfg=new CorsConfiguration()
               cfg.setAllowedOrigins(
                Array.asList(
                    "http://localhost:3000",
                )
               );

               return null
            }
            
        }
        )

        return null;
    }
}
