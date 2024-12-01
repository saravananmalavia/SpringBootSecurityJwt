package com.concept.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
   @Override
   protected void configure(HttpSecurity http) throws Exception {
      http
         .authorizeRequests()
            .antMatchers("/", "/home").permitAll()
            .anyRequest().authenticated()
            .and()
         .formLogin()
            .loginPage("/login")
            .permitAll()
            .and()
            .logout()
            .permitAll();
   }
   @Autowired
   public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
     auth
         .inMemoryAuthentication()
         .withUser("user").password("password").roles("USER");
     
     
   /*  In spring-security-core:5.0.0.RC1, the default PasswordEncoder is built as a DelegatingPasswordEncoder.
     When you store the users in memory, you are providing the passwords in plain text and
     when trying to retrieve the encoder from the DelegatingPasswordEncoder to validate the password
     it can't find one that matches the way in which these passwords were stored.
     
     You can also simply prefix {noop} to your passwords in order 
     for the DelegatingPasswordEncoder use the NoOpPasswordEncoder to validate these passwords.
      Notice that NoOpPasswordEncoder is deprecated though, as it is not a good practice to store passwords in plain text.
          */
     
     
   }
}