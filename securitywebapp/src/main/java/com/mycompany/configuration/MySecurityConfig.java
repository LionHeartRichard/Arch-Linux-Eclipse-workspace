package com.mycompany.configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		UserBuilder userBuilder = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication().withUser(userBuilder.username("kein").password("kein").roles("ROOT"))
				.withUser(userBuilder.username("roma").password("roma").roles("EMPLOYEE"))
				.withUser(userBuilder.username("elena").password("elena").roles("HR"))
				.withUser(userBuilder.username("ivan").password("ivan").roles("MANAGER", "HR"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").hasAnyRole("EMPLOYEE", "HR", "MANAGER", "ROOT")
				.antMatchers("/hr_info").hasAnyRole("HR").antMatchers("/manager_info/**").hasAnyRole("MANAGER").and()
				.formLogin().permitAll();
	}

}
