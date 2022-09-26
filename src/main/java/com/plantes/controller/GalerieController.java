package com.plantes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.plantes.model.Image;
import com.plantes.services.ImageService;
import com.plantes.services.PlanteService;

@Controller
public class GalerieController {
	
	@Autowired
	ImageService imageService;
	@Autowired
	PlanteService planteService;

	@GetMapping("/galerie")
	public String getGalerie(Model model) {
		
		
		List<Image> listeRandom1 = imageService.randomList();
	
		
		model.addAttribute("listeRandom1", listeRandom1);

		
		return "pages/galerie";
	}
	
	
	
	@PostMapping("/galerie")
	public String postGalerie() {
		return "pages/galerie";
	}
}
