package com.project.app.config;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "Blog-Service API 명세서",
                description = "블로그 API 명세서",
                version = "v1"))
@Configuration
public class SwaggerConfiguration {
	 
}