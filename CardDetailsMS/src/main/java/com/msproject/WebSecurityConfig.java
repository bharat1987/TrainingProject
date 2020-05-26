package com.msproject;


import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;


@EnableWebSecurity
@Order(3)
public class WebSecurityConfig extends ResourceServerConfigurerAdapter {

	@Override
	 public void configure(HttpSecurity http) throws Exception {
	        http
	            .authorizeRequests()
	            .anyRequest().authenticated();
	    }
	
}
