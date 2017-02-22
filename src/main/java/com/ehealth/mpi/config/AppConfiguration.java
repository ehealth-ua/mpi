package com.ehealth.mpi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;;

@Configuration
@ComponentScan(basePackages = {
		"com.ehealth.mpi" }, excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = WebMvcConfig.class))
public class AppConfiguration {

	@Bean
	public LocalValidatorFactoryBean localValidatorFactoryBean() {
		return new LocalValidatorFactoryBean();
	}

}
