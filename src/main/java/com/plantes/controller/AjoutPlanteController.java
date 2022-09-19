package com.plantes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.plantes.model.Plante;
import com.plantes.repository.PlanteRepository;

@Controller
public class AjoutPlanteController {
	
	@Autowired
	private PlanteRepository planteRepository;
	
	@GetMapping("/ajout-plante")
	public String getAjoutPlante() {
		return "pages/ajout-plante";
	}
	
	
	@PostMapping("/ajout-plante")
	public String postAjoutPlante(@Validated Plante plante, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "pages/ajout-plante";
			
		} else {
			
			planteRepository.save(plante);
		}
		return "redirect:/collection";
	}

}
