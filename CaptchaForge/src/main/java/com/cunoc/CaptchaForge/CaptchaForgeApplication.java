package com.cunoc.CaptchaForge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CaptchaForgeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaptchaForgeApplication.class, args);
	}

	@Configuration
	public class WebConfig implements WebMvcConfigurer {
		@Override
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**") // Permitir todas las rutas
					.allowedOrigins("http://localhost:4200") // Origen permitido
					.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos permitidos
					.allowedHeaders("*") // Encabezados permitidos
					.allowCredentials(true); // Si necesitas enviar cookies
		}
	}

}
