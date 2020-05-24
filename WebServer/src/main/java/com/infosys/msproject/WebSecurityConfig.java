package com.infosys.msproject;


import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;


@Configuration
@EnableWebSecurity
@Order(3)
public class WebSecurityConfig extends ResourceServerConfigurerAdapter {

	  @Override
	    public void configure(final HttpSecurity http) throws Exception {
	    	http.csrf().disable()
	    	.cors()
	    	.and()
	    	 .authorizeRequests()
	    	 .antMatchers(HttpMethod.OPTIONS).permitAll()
	    	 .antMatchers("/register","/registerUser").permitAll()
	    	 .anyRequest().authenticated();
	    	http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
	    	http.sessionManagement()
	    	  .sessionFixation().migrateSession();
	    	
	    }
	   
  
}
