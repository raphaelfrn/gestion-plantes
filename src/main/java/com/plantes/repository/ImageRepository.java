package com.plantes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.plantes.model.Image;
import com.plantes.model.Plante;

public interface ImageRepository extends JpaRepository<Image, Long>{

	List<Image> findByPlante(Optional<Plante> plante);
	
	
	@Query(value="SELECT * FROM Image ORDER BY RAND() LIMIT 3", nativeQuery=true)
	List<Image> randomList();
	
	
	
}
