package com.plantes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.plantes.services.ImageService;
import com.plantes.services.PlanteService;

@Controller
public class StatistiquesController {
	
	@Autowired
	ImageService imageService;
	@Autowired
	PlanteService planteService;

	@GetMapping("/statistiques")
	public String getStats(Model model) {
		
		// plantes
		Long countPlantes = planteService.getPlanteCount();
		Double avgRusticite = planteService.moyenneRusticite();
		
		
		// images
		Long countImages = imageService.getImageCount();
		
		model.addAttribute("countPlantes", countPlantes);
		model.addAttribute("avgRusticite",avgRusticite);
		model.addAttribute("countImages",countImages);
		
		return "pages/statistiques";
	}
	
	
	@PostMapping("/statistiques")
	public String postStats() {
		return "pages/statistiques";
	}
	
	
}
