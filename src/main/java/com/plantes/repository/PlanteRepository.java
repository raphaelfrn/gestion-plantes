package com.plantes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.plantes.model.Plante;

public interface PlanteRepository extends JpaRepository<Plante, Long> {

	@Query(value= "SELECT * FROM plante ORDER BY id_plante", nativeQuery = true)
	List<Plante> planteOrderById();
	
	@Query(value= "SELECT * FROM plante ORDER BY nom", nativeQuery = true)
	List<Plante> planteOrderByNom();
	
	@Query(value= "SELECT * FROM plante ORDER BY origine", nativeQuery = true)
	List<Plante> planteOrderByOrigine();
	
	@Query(value= "SELECT * FROM plante ORDER BY dimension", nativeQuery = true)
	List<Plante> planteOrderByDimension();

	@Query(value="SELECT * FROM plante WHERE id_plante LIKE ? OR nom LIKE ? OR origine LIKE ? OR dimension LIKE ? OR rusticite LIKE ? OR floraison LIKE ? "
			+ "OR exposition LIKE ? OR terrain LIKE ? ", nativeQuery = true)
	List<Plante> search();
	
	
	
	
	
	
}


