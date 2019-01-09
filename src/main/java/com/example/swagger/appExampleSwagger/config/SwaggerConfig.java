package com.example.swagger.appExampleSwagger.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket productApi() {
		 return new Docket(DocumentationType.SWAGGER_2)
	                .select()                
	                .apis(RequestHandlerSelectors.basePackage("com.example.swagger.appExampleSwagger.controller"))
	                .paths(regex("/contacto.*"))
	                .build()
	                .apiInfo(appInfo());
	}
	
	
	/**
	 * About our API
	 * @return
	 */
	private ApiInfo appInfo() {
		//ApiInfo _aApiInfo = new ApiInfo(title, description, version, termsOfServiceUrl, contact, license, licenseUrl);		
		return new ApiInfo("Spring Boot - Application with Swagger", 
						"Application Services REST", 
						"1.0", 
						"services", 
						new Contact("Luis Miguel Gomez", "https://github.com/lgomezs", "lmgomez.saavedra@gmail.com"), 
						"Apache License Version 2.0",
						 "https://www.apache.org/licenses/LICENSE-2.0");		
	}
	
}
