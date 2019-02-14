package com.example.authservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@Order(1)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http.requestMatchers()
                .antMatchers("/oauth/authorize", "/login")
            .and()
                .authorizeRequests().anyRequest().authenticated()
            .and()
                .formLogin().permitAll();
        // @formatter:on
    }

    @Override
    protected void configure(
            AuthenticationManagerBuilder auth) throws Exception {
        // @formatter:off
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
             .and()
                .withUser("user")
                .password(passwordEncoder().encode("user"))
                .roles("USER");
        // @formatter:on
    }
}