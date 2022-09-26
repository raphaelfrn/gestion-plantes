package com.plantes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plantes.model.Image;
import com.plantes.model.Plante;
import com.plantes.repository.ImageRepository;

@Service
public class ImageService {

	@Autowired
	private ImageRepository imageRepository;

	
	// find By Plante
	public List<Image> findByPlante(Optional<Plante> plante) {
		
		return imageRepository.findByPlante(plante);
	}
	
	// Save
	public Image save(Image image) {
		return imageRepository.save(image);
	}

	// Find Image By Id
	public Optional<Image> findById(Long idImage) {
		
		return imageRepository.findById(idImage);
	}
	
	// Find all
	
	public List<Image> findAll(){
		return imageRepository.findAll();
		}

	// Random List pour galerie
	
	public List<Image> randomList(){
		return imageRepository.randomList();
	}
	
	// count image
	
	public Long getImageCount() {
		return imageRepository.count();
	}
	
}
