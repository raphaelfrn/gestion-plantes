package com.plantes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.plantes.model.Plante;
import com.plantes.repository.PlanteRepository;
import com.plantes.services.PlanteService;

@Controller
public class CollectionController {
	
	@Autowired
	private PlanteRepository planteRepository;
	@Autowired
	private PlanteService planteService;

	@GetMapping("/collection")
	public String getCollection(Plante plante, Model model, String keyword,
			@RequestParam(name="btnFilterId", required = false) Long btnFilterId, 
			@RequestParam(name="btnFilterNom", required = false) Long btnFilterNom,
			@RequestParam(name="btnFilterOrigine", required = false) Long btnFilterOrigine,
			@RequestParam(name="btnFilterDimension", required = false) Long btnFilterDimension) {
		
		List<Plante> listePlantes = planteService.findAllPlantes();
		model.addAttribute("listePlantes",listePlantes);
		
		
//		if(btnFilterId != null ) { 	
//		model.addAttribute("listePlantes", planteService.findByOrderById_plante());	
//		}
		
		if(btnFilterNom != null ) {
			model.addAttribute("listePlantes", planteService.findByOrderByNomAsc());
			}
		
		if(btnFilterOrigine != null ) {
			model.addAttribute("listePlantes", planteService.findByOrderByOrigineAsc());
			}
		
		if(btnFilterDimension != null ) {
			model.addAttribute("listePlantes", planteRepository.findAll(Sort.by(Sort.Direction.ASC, "dimension")));
			}
		
		if(keyword != null) {
		model.addAttribute("listePlantes", planteService.findByKeyword(keyword));
		} else {
			model.addAttribute("listePlantes",listePlantes);
		}
		
		
		return "pages/collection";
	}
	
	@PostMapping("/collection")
	public String postCollection() {
		return "pages/collection";
	}
	
	

	
}
