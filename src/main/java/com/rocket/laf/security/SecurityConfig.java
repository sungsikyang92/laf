package com.rocket.laf.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig{

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return web -> web.ignoring().antMatchers("/resources/**");
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http.csrf().disable()
            .headers()
                .frameOptions().disable().and()
            .authorizeRequests()
                .antMatchers("/**").permitAll()
                // .antMatchers("/user/signUp").permitAll()
                // .antMatchers("/user/signUpForm").permitAll()
                .antMatchers("/user/**").hasRole("USER")
                .anyRequest().authenticated().and()
            .formLogin()
                .loginPage("/user/login").permitAll()
                .defaultSuccessUrl("/index")
                .failureForwardUrl("/index")
                .and()
            .logout()
                .logoutUrl("/user/logout").and()
            .build();

    }


    
}
