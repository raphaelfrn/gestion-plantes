package com.plantes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.plantes.model.Plante;

public interface PlanteRepository extends JpaRepository<Plante, Long> {


	
	List<Plante> findAllByOrderByNomAsc();
	
	List<Plante> findAllByOrderByOrigineAsc();
	
	List<Plante> findAllByOrderByDimensionAsc();

	
	@Query(value="SELECT * FROM Plante p WHERE p.id_plante LIKE %:keyword% OR p.nom LIKE %:keyword% or p.origine LIKE %:keyword% OR"
			+ " p.dimension LIKE %:keyword% OR p.rusticite LIKE %:keyword% OR p.floraison LIKE %:keyword% OR p.exposition LIKE %:keyword% "
			+ "OR p.terrain LIKE %:keyword%", nativeQuery=true)
	List<Plante> findByKeyword(@Param("keyword") String keyword);

	
	
	
	
}


