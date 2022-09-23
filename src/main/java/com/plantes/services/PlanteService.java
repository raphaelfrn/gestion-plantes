package com.plantes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plantes.model.Plante;
import com.plantes.repository.PlanteRepository;

@Service
public class PlanteService {

	@Autowired
	private PlanteRepository planteRepository;
	
	
	// find all plantes
	public List<Plante> findAllPlantes(){
		return planteRepository.findAll();
	}
	
	// find Optional by Id
	public Optional<Plante> findById(Long id) {
		return planteRepository.findById(id);
	}
		
	
	
	// save
	public Plante save(Plante planteUpdate) {
		return planteRepository.save(planteUpdate);
	}
	
	// filter plante by name 
	public List<Plante> findByOrderByNomAsc(){
		return planteRepository.findAllByOrderByNomAsc();
	}
	
	// filter plant by origine
	public List<Plante> findByOrderByOrigineAsc(){
		return planteRepository.findAllByOrderByOrigineAsc();
	}
	
	// filter plante by dimension
	public List<Plante> findByOrderByDimensionAsc(){
		return planteRepository.findAllByOrderByDimensionAsc();
	}
	
	
	
	// get plante by keyword
	public List<Plante> findByKeyword(String keyword){
		return planteRepository.findByKeyword(keyword) ;
	}
}
