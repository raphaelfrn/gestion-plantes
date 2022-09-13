package com.plantes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DetailsPlanteController {


	@GetMapping("/details-plante")
	public String getDetails() {
		return "pages/details-plante";
	}
	
	@PostMapping("/details-plante")
	public String postDetails() {
		return "pages/details-plante";
	}
}
