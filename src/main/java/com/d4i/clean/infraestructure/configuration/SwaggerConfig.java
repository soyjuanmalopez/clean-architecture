package com.d4i.clean.infraestructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
	    return new Docket(DocumentationType.SWAGGER_2)
	            .select()
	            .apis(RequestHandlerSelectors.basePackage("com.d4i.clean.infraestructure"))
	            .paths(PathSelectors.any())
	            .build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Soy Juanmalopez").description("Apis realizadas con clean arquitecture")
				.termsOfServiceUrl("https://www.everis.com").license("everis").licenseUrl("https://www.everis.com")
				.version("1.0").build();
	}

}
