package com.plantes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GalerieController {

	@GetMapping("/galerie")
	public String getGalerie() {
		return "pages/galerie";
	}
	
	@PostMapping("/galerie")
	public String postGalerie() {
		return "pages/galerie";
	}
}
