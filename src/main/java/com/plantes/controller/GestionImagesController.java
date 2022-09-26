package com.plantes.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.plantes.FileUploadUtil;
import com.plantes.model.Image;
import com.plantes.model.Plante;
import com.plantes.repository.ImageRepository;
import com.plantes.repository.PlanteRepository;
import com.plantes.services.ImageService;
import com.plantes.services.PlanteService;

@Controller
public class GestionImagesController {

	@Autowired
	PlanteService planteService;
	@Autowired
	ImageService imageService;
	@Autowired
	ImageRepository imageRepository;
	@Autowired
	PlanteRepository planteRepository;
	
	
	// Affichage de la page
	
	@GetMapping("/gestion-images/{id}")
	public String getGestionImages(@PathVariable(value="id") Long idPlante, Model model) {
	
		Optional<Plante> plante = planteService.findById(idPlante);
		
		List<Image> listeImages = imageService.findByPlante(plante);
		
		if(plante.isPresent()) {
			model.addAttribute("listeImages", listeImages);
		}
		
		return "pages/gestion-images";
	}
	
	// Delete an image
	
	@GetMapping("/deleteImage/{id}")
	public String delete(@PathVariable(value="id") Long idImage, Model model) {
		Optional<Image> ImageDelete =  imageService.findById(idImage); 
		
		if(ImageDelete.isPresent()) {
			imageRepository.delete(ImageDelete.get());
		}
		
		return "redirect:/collection";
	}
	
	
	// upload a new image
	
	@PostMapping("/gestion-images/{id}")
	public String postGestionImages(@PathVariable(value="id") Long idPlante,
			@RequestParam(value= "inputImage", required=false) MultipartFile multipartFile) throws IOException {
		
		
		if( multipartFile.getSize() > 0) {
			
			Optional<Plante> plante = planteRepository.findById(idPlante);
			
			Image newImage = new Image();
			String inputImage = StringUtils.cleanPath(multipartFile.getOriginalFilename());
			newImage.setImage(inputImage);
			
			newImage.setPlante(plante.get());
			
			Image dbImage = imageService.save(newImage);
			String uploadDir = "src/main/resources/static/plante-images/" + dbImage.getPlante().getId();
			
			FileUploadUtil.saveFile(uploadDir, multipartFile, inputImage);
			
		} 
		
		
		
		
		
		return "redirect:/gestion-images/{id}";
	}
}
