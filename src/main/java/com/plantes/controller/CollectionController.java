package com.plantes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.plantes.model.Plante;
import com.plantes.repository.PlanteRepository;

@Controller
public class CollectionController {
	
	@Autowired
	private PlanteRepository planteRepository;

	@GetMapping("/collection")
	public String getCollection(Plante plante, Model model) {
		
		findAllPlantes(model);
		
		return "pages/collection";
	}
	
	@PostMapping("/collection")
	public String postCollection(@Validated Plante plante, BindingResult bindingResult, Model model) {
		findAllPlantes(model);
	if(bindingResult.hasErrors()) {
			
			return "pages/collection";
		} else {
			
			planteRepository.save(plante);
		}
	
	
		return "redirect:/	collection";
	}
	
	
	
	// Methode to read all 
	
	public List<Plante> findAllPlantes(Model model){
		List<Plante> listePlantes = planteRepository.findAll();
		model.addAttribute("listePlantes",listePlantes);
		return listePlantes;
	}
	
}
