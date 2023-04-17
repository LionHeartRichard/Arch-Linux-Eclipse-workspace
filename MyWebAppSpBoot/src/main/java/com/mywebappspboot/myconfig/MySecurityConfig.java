package com.mywebappspboot.myconfig;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfiguration {

	@Autowired
	DataSource dataSource;

	protected void getConfigSecurityFromDataSource(AuthenticationManagerBuilder managerBuilder) throws Exception {
		managerBuilder.jdbcAuthentication().dataSource(dataSource);
	}

@Bean
	protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().requestMatchers(&quot;/**&quot;).hasRole(&quot;USER&quot;)
		  			)
		  			.formLogin(withDefaults());
		  		return http.build();
		
//		httpSecurity.authorizeRequests().requestMatchers("/api").hasAnyRole("ADMIN").
//		requestMatchers("/books").hasAnyRole("ADMIN").and().formLogin().permitAll();
	}

}
