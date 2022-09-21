package com.plantes.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.plantes.FileUploadUtil;
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
	//	model.addAttribute("listePlantes",listePlantes);
		
		
		if(btnFilterId != null ) { 	
		model.addAttribute("listePlantes", listePlantes);	
		}
		
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
			} 
		
		if(btnFilterNom == null && btnFilterOrigine == null && btnFilterDimension == null && btnFilterId == null && keyword == null) {
			model.addAttribute("listePlantes",listePlantes);
		 	}
		
		
		return "pages/collection";
	}
	
	@PostMapping("/collection")
	public String postCollection(@Validated Plante plante, BindingResult bindingResult, 
			@RequestParam("primaryImage") MultipartFile mainMultipartFile,
			@RequestParam("extraImage") MultipartFile[] extraMultipartFiles) throws IOException
			 {
		
		if(bindingResult.hasErrors()) {
			System.out.println(bindingResult.getFieldError());
			return "pages/collection";
			
			} else {
			
					String mainImageName = StringUtils.cleanPath(mainMultipartFile.getOriginalFilename());
					plante.setMainImage(mainImageName);
					
					int count = 0;
					for(MultipartFile extraMultipart : extraMultipartFiles) {
						String extraImageName = StringUtils.cleanPath(extraMultipart.getOriginalFilename());
						if (count == 0) plante.setExtraImage1(extraImageName);
						if (count == 1) plante.setExtraImage2(extraImageName);
						if (count == 2) plante.setExtraImage3(extraImageName);
						count ++;
						}
						
					System.out.println(plante);
						
					Plante createdPlante =	planteRepository.save(plante);
					String uploadDir = "./plante-images/" + createdPlante.getId_plante();
					
					FileUploadUtil.saveFile(uploadDir, mainMultipartFile, mainImageName);
					
					for(MultipartFile extraMultipart : extraMultipartFiles) {
						String fileName = StringUtils.cleanPath(extraMultipart.getOriginalFilename());
						
						FileUploadUtil.saveFile(uploadDir, extraMultipart, fileName);
						}
		
					}
		
		return "redirect:/collection";
	}
	
//	@PostMapping("/collection")
//	public RedirectView saveImage(Image image, @RequestParam("image") MultipartFile multipartFile) throws IOException{
//		
//		 String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
//		 image.setUrl(fileName);
//	         
//		 Image savedImage = imageRepository.save(image);
//	 
//	        String uploadDir = "/plante-images/" + savedImage.getId_image();
//	 
//	        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
//		
//		return new RedirectView("/collection", true);
//		
//	}
	

	
}
