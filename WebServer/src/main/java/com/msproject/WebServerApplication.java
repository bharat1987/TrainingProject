package com.msproject;

import java.util.Locale;

import org.apache.catalina.Context;
import org.apache.tomcat.util.scan.StandardJarScanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;

import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;

import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableResourceServer
public class WebServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebServerApplication.class, args);
	}
	@Bean
	public MessageSource messageSource() {
	    ReloadableResourceBundleMessageSource messageSource
	      = new ReloadableResourceBundleMessageSource();
	     
	    messageSource.setBasename("classpath:message");
	    messageSource.setDefaultEncoding("UTF-8");
	    return messageSource;
	}
	@Bean
	public LocalValidatorFactoryBean getValidator() {
	    LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
	    bean.setValidationMessageSource(messageSource());
	    return bean;
	}
	@Bean
	public LocaleResolver localeResolver() {
	   SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
	   sessionLocaleResolver.setDefaultLocale(Locale.ENGLISH);
	   return sessionLocaleResolver;
	}
	 @Bean
	  public TomcatServletWebServerFactory tomcatFactory() {
	    return new TomcatServletWebServerFactory() {
	      @Override
	      protected void postProcessContext(Context context) {
	        ((StandardJarScanner) context.getJarScanner()).setScanManifest(false);
	      }
	    };
	  }

}
