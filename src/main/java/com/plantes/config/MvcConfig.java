package com.plantes.config;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class MvcConfig implements WebMvcConfigurer{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	Path ImageUploadDir = Paths.get("./plante-images");
	String ImageUploadPath = ImageUploadDir.toFile().getAbsolutePath();
	
	registry.addResourceHandler("/plantes-image/**").addResourceLocations("file:/" + ImageUploadPath + "/");
	
	
	}

	
	
}
