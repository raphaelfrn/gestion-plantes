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

	@Query("SELECT p FROM Plante p WHERE p.id_plante LIKE ?1% OR p.nom LIKE ?1% OR p.origine LIKE ?1% OR p.dimension LIKE ?1% OR p.rusticite LIKE ?1% OR p.floraison LIKE ?1% "
			+ "OR p.exposition LIKE ?1% OR p.terrain LIKE ?1% ")
	List<Plante> searchBy(String mot);
	
	
	
	
	
	
}


