package com.plantes.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.plantes.model.Plante;
import com.plantes.repository.PlanteRepository;
import com.plantes.services.PlanteService;

@Controller
public class DetailsPlanteController {

	@Autowired
	PlanteService planteService;
	@Autowired
	PlanteRepository planteRepository;

	@GetMapping("/details-plante/{id}")
	public String getDetails(@PathVariable(value="id") Long idPlante, Model model) {
		
		Optional<Plante> plante = planteService.findById(idPlante);
		
		if(plante.isPresent()) {
			model.addAttribute("plante", plante.get());
		}
		
		return "pages/details-plante";		
	}
	
	@PostMapping("/details-plante/{id}")
	public String postDetails(@PathVariable(value="id") Long idPlante, Model model, @Validated Plante plante) {
		
		Optional<Plante> planteUpdate = planteService.findById(idPlante);
		if(planteUpdate.isPresent()) {
			
			planteService.save(plante);
		}
		
		return "pages/details-plante";
	}
	
	
	@GetMapping("/deletePlante/{id}")
	public String delete(@PathVariable(value="id") Long idPlante, Model model) {
		Optional<Plante> planteDelete =  planteService.findById(idPlante); 
		
		if(planteDelete.isPresent()) {
			planteRepository.delete(planteDelete.get());
		}
		
		return "redirect:/collection";
	}
	
}
