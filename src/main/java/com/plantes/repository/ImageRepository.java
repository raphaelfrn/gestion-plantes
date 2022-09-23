package com.plantes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plantes.model.Image;
import com.plantes.model.Plante;

public interface ImageRepository extends JpaRepository<Image, Long>{

	List<Image> findByPlante(Optional<Plante> plante);
	
	
	
}
