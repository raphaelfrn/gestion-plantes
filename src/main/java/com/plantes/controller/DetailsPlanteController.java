package com.plantes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.plantes.model.Image;
import com.plantes.model.Plante;
import com.plantes.repository.ImageRepository;
import com.plantes.repository.PlanteRepository;
import com.plantes.services.ImageService;
import com.plantes.services.PlanteService;

@Controller
public class DetailsPlanteController {

	@Autowired
	PlanteService planteService;
	@Autowired
	PlanteRepository planteRepository;
	@Autowired
	ImageService imageService;
	@Autowired
	ImageRepository imageRepository;
	
	// affichage

	@GetMapping("/details-plante/{id}")
	public String getDetails(@PathVariable(value="id") Long idPlante, Model model) {
		
		Optional<Plante> plante = planteService.findById(idPlante);
		List<Image> listeImages = imageService.findByPlante(plante);
		
		if(plante.isPresent()) {
			model.addAttribute("plante", plante.get());
			model.addAttribute("listeImages", listeImages);
		}
		
		return "pages/details-plante";		
	}
	
	// Update a plant 
	
	@PostMapping("/details-plante/{id}")
	public String postDetails(@PathVariable(value="id") Long idPlante, Model model, @Validated Plante plante) {
					
		Optional<Plante> planteUpdate = planteService.findById(idPlante);
		if(planteUpdate.isPresent()) {
			
			planteService.save(plante);
			
		}
		
		return "redirect:/details-plante/{id}";
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
	

