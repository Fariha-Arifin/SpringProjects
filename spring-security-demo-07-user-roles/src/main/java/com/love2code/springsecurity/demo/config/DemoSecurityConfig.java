package com.love2code.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication().withUser(users.username("fariha")
				.password("1234").roles("STUDENT"));
		auth.inMemoryAuthentication().withUser(users.username("arifin")
				.password("123").roles("STUDENT","MANAGER"));
		auth.inMemoryAuthentication().withUser(users.username("era")
				.password("12").roles("STUDENT","ADMIN"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers("/").hasRole("STUDENT")
		.antMatchers("/leaders/**").hasRole("MANAGER")
		.antMatchers("/admin/**").hasRole("ADMIN")
		.and()
		.formLogin()
		.loginPage("/showMyLoginPage")
		.loginProcessingUrl("/authenticateTheUser")
		.permitAll()
		.and()
		.logout()
        .permitAll()
        .and()
        .exceptionHandling()
        .accessDeniedPage("/access-denied");
	}
	
	

}
