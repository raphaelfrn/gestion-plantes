package com.plantes.config;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class MvcConfig implements WebMvcConfigurer{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	Path imageUploadDir = Paths.get("src/main/resources/static/plante-images/");
	String imageUploadPath = imageUploadDir.toFile().getAbsolutePath();
	
	registry.addResourceHandler("src/main/resources/static/plante-images/**").addResourceLocations("file:/" + imageUploadPath + "/");
	
	
	}

	
	
}
