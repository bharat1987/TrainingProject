package com.msproject;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@EnableOAuth2Sso
@Configuration
public class ZuulConfiguration extends WebSecurityConfigurerAdapter {
		    @Override
	    public void configure(HttpSecurity http) throws Exception {
	    	http.csrf().disable()
	    	.cors()
	    	.and()
	    	.antMatcher("/**").authorizeRequests()
	    	.antMatchers(HttpMethod.OPTIONS).permitAll()
	    	 .antMatchers("/MS-Project/web/register","/MS-Project/web/registerUser","/MS-Project/signup","/MS-Project/checkUserId/**").permitAll()
	    	 .anyRequest().authenticated();
	    	http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
	    	http.sessionManagement()
	    	  .sessionFixation().migrateSession();
	    	 
	    }
		    
		    @Override
		      public void configure(WebSecurity web) throws Exception {
		        web.ignoring()
		          .antMatchers(HttpMethod.OPTIONS);
		      }
	    
	   
	

}
