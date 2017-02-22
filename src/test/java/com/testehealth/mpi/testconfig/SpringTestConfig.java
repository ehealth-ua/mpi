package com.testehealth.mpi.testconfig;

import org.springframework.context.annotation.ComponentScan; 
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ehealth.mpi.config.WebMvcConfig;

@Configuration
@ComponentScan(basePackages = { "com.ehealth.mpi", "com.testehealth.mpi" }, excludeFilters = {
		@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = WebMvcConfig.class) })
@EnableTransactionManagement
public class SpringTestConfig {

}
