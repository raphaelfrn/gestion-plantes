package com.plantes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.plantes.model.Plante;

public interface PlanteRepository extends JpaRepository<Plante, Long> {

	
	
	List<Plante> findByOrderByNomAsc();
	
	List<Plante> findByOrderByOrigineAsc();
	
	List<Plante> findByOrderByDimensionAsc();

	@Query("SELECT p FROM Plante p WHERE p.id_plante LIKE ?1% OR p.nom LIKE ?1% OR p.origine LIKE ?1% OR p.dimension LIKE ?1% OR p.rusticite LIKE ?1% OR p.floraison LIKE ?1% "
			+ "OR p.exposition LIKE ?1% OR p.terrain LIKE ?1% ")
	List<Plante> searchBy(String mot);
	
	
	
	
	
	
}


