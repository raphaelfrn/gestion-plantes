package com.plantes.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.plantes.FileUploadUtil;
import com.plantes.model.Plante;
import com.plantes.repository.ImageRepository;
import com.plantes.repository.PlanteRepository;
import com.plantes.services.PlanteService;

@Controller
public class DetailsPlanteController {

	@Autowired
	PlanteService planteService;
	@Autowired
	PlanteRepository planteRepository;
	
	@Autowired
	ImageRepository imageRepository;
	
	// affichage

	@GetMapping("/details-plante/{id}")
	public String getDetails(@PathVariable(value="id") Long idPlante, Model model) {
		
		Optional<Plante> plante = planteService.findById(idPlante);
		
		if(plante.isPresent()) {
			model.addAttribute("plante", plante.get());
		}
		
		return "pages/details-plante";		
	}
	
	// Update a plant + upload main Image
	
	@PostMapping("/details-plante/{id}")
	public String postDetails(@PathVariable(value="id") Long idPlante, Model model, @Validated Plante plante,
			@RequestParam("primaryImage") MultipartFile multipartFile) throws IOException {
		
		Optional<Plante> planteUpdate = planteService.findById(idPlante);
		if(planteUpdate.isPresent()) {
			
			String mainImageName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
			plante.setMainImage(mainImageName);
			
			
			Plante updatedPlante = planteService.save(plante);
			String uploadDir = "src/main/resources/static/plante-images/" + updatedPlante.getId();
			
			FileUploadUtil.saveFile(uploadDir, multipartFile, mainImageName);
		}
		
		return "pages/details-plante";
	}
	
	// Delete plante
	
	@GetMapping("/deletePlante/{id}")
	public String delete(@PathVariable(value="id") Long idPlante, Model model) {
		Optional<Plante> planteDelete =  planteService.findById(idPlante); 
		
		if(planteDelete.isPresent()) {
			planteRepository.delete(planteDelete.get());
		}
		
		return "redirect:/collection";
	}
	
//	@PostMapping("/updateMainImage/{id}")
//		public String postMainImage(@Validated Image image, BindingResult bindingResult,
//				@RequestParam("primaryImage") MultipartFile multipartFile) throws IOException {
//		
//		if(bindingResult.hasErrors()) {
//			System.out.println(bindingResult.getFieldError());
//			return "pages/details-plante";
//			
//		} else {
//			String mainImageName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
//			image.setImage(mainImageName);
//				
//			Image createdImage =	imageRepository.save(image);
//			String uploadDir = "src/main/resources/static/plante-images/" + createdImage.getId_image();
//			
//			FileUploadUtil.saveFile(uploadDir, multipartFile, mainImageName);
//			
//		}
//		
//			
//			return "redirect:/details-plante";
//		}
	
	
	
	
}
	

