package com.allclearwas.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@OpenAPIDefinition(
	servers = {
		@Server(url = "http://localhost:8080", description = "All_Clear local server")
	}
)
@Configuration
public class SwaggerConfig {

	@Bean
	public GroupedOpenApi allApi() {
		return GroupedOpenApi.builder()
			.group("전체 보기")
			.packagesToScan("com.allclearwas")
			.build();
	}

	@Bean
	public GroupedOpenApi studentApi() {
		return GroupedOpenApi.builder()
			.group("학생 전체 API")
			.packagesToScan("com.allclearwas.domains.student")
			.build();
	}

	@Bean
	public GroupedOpenApi courseApi() {
		return GroupedOpenApi.builder()
			.group("강의 전체 API")
			.packagesToScan("com.allclearwas.domains.course")
			.build();
	}

	@Bean
	public GroupedOpenApi enrollmentApi() {
		return GroupedOpenApi.builder()
			.group("수강신청 전체 API")
			.packagesToScan("com.allclearwas.domains.enrollment")
			.build();
	}

	@Bean
	public OpenAPI openAPI() {

		SecurityRequirement securityRequirement = new SecurityRequirement().addList("JWT");
		Components components = new Components().addSecuritySchemes("JWT", new SecurityScheme()
			.name("JWT")
			.type(SecurityScheme.Type.HTTP)
			.scheme("bearer")
			.bearerFormat("JWT")
		);

		return new OpenAPI()
			.info(apiInfo())
			.addSecurityItem(securityRequirement)
			.components(components);
	}

	private Info apiInfo() {
		return new Info()
			.title("All Clear API")
			.description("All Clear Swagger")
			.version("1.0.0");
	}
}
