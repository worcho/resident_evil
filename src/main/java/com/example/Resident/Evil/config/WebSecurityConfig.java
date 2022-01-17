package com.example.Resident.Evil.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    public WebSecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login", "/", "/register", "/css/bootstrap.css", "/css/style.css", "/scripts/bootstrap.min.js").permitAll()
                .antMatchers("/add").hasAnyRole("ADMIN","MODERATOR")
                .antMatchers("/edit/*").hasAnyRole("ADMIN","MODERATOR")
                .antMatchers("/delete/**").hasAnyRole("ADMIN","MODERATOR")
                .antMatchers("/users").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .passwordParameter("password")
                .usernameParameter("username")
                .successForwardUrl("/")
                .and().userDetailsService(userDetailsService)
                .logout()
                .and()
                .exceptionHandling().accessDeniedPage("/accessError");
    }
}
