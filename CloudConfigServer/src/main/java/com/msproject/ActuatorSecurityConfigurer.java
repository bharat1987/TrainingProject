package com.msproject;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


public class ActuatorSecurityConfigurer extends WebSecurityConfigurerAdapter {
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf()
			.disable().httpBasic();
	}
}