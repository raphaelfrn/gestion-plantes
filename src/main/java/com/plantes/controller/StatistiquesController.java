package com.plantes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.plantes.model.Image;
import com.plantes.model.Plante;
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
		
		List<Plante> listePlantes = planteService.findAllPlantes();
		List<Image> listeImages = imageService.findAll();
		
		model.addAttribute("listePlantes", listePlantes);
		model.addAttribute("listeImages", listeImages);
		
		return "pages/statistiques";
	}
	
	
	@PostMapping("/statistiques")
	public String postStats() {
		return "pages/statistiques";
	}
	
	
}
