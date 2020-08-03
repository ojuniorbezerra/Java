package com.erudio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


	@Bean
	public Docket swaggerPersonApi10() {
	    return new Docket(DocumentationType.SWAGGER_2)
	        .groupName("api-1.0")
	        .select()
	            .apis(RequestHandlerSelectors.basePackage("com.erudio.controller"))
	            .paths(PathSelectors.any())
	        .build()
	        .apiInfo(new ApiInfoBuilder().version("1.0").title("Person API").description("Documentation Person API v1.0").build());
	}
	@Bean
	public Docket swaggerPersonApi11() {
	    return new Docket(DocumentationType.SWAGGER_2)
	        .groupName("api-1.1")
	        .select()
	            .apis(RequestHandlerSelectors.basePackage("com.erudio.v1"))
	            .paths(PathSelectors.any())
	        .build()
	        .apiInfo(new ApiInfoBuilder().version("1.1").title("Person API").description("Documentation Person API v1.1").build());
	}
	/**
	@Bean
	public Docket swaggerPersonApi12() {
	    return new Docket(DocumentationType.SWAGGER_2)
	        .groupName("api-1.2")
	        .select()
	            .apis(RequestHandlerSelectors.basePackage("com.erudio.controller"))
	            .paths(PathSelectors.any())
	        .build()
	        .apiInfo(new ApiInfoBuilder().version("1.2").title("Person API").description("Documentation Person API v1.2").build());
	}
	**/
}
