package com.plantes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.plantes.model.Plante;
import com.plantes.repository.PlanteRepository;

@Controller
public class CollectionController {
	
	@Autowired
	private PlanteRepository planteRepository;

	@GetMapping("/collection")
	public String getCollection(Plante plante, Model model, 
			@RequestParam(name = "btnSearch", required = false) Long btnSearch, 
			@RequestParam(name = "inputSearch", required = false) String inputSearch,
			@RequestParam(name="btnFilterId", required = false) Long btnFilterId, 
			@RequestParam(name="btnFilterNom", required = false) Long btnFilterNom,
			@RequestParam(name="btnFilterOrigine", required = false) Long btnFilterOrigine,
			@RequestParam(name="btnFilterDimension", required = false) Long btnFilterDimension) {
		
		findAllPlantes(model);
		
		if(btnFilterId != null ) {
		model.addAttribute("listePlantes", planteRepository.planteOrderById());
		}
		
		if(btnFilterNom != null ) {
			model.addAttribute("listePlantes", planteRepository.planteOrderByNom());
			}
		
		if(btnFilterOrigine != null ) {
			model.addAttribute("listePlantes", planteRepository.planteOrderByOrigine());
			}
		
		if(btnFilterDimension != null ) {
			model.addAttribute("listePlantes", planteRepository.planteOrderByDimension());
			}
		
		if(btnSearch != null) {
		model.addAttribute("listePlantes", planteRepository.searchBy(inputSearch));
		}
		
		
		return "pages/collection";
	}
	
	@PostMapping("/collection")
	public String postCollection() {
		return "pages/collection";
	}
	
	
	
	// Methode to read all 
	
	public List<Plante> findAllPlantes(Model model){
		List<Plante> listePlantes = planteRepository.findAll();
		model.addAttribute("listePlantes",listePlantes);
		return listePlantes;
	}
	
}
