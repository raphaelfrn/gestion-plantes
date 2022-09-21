package com.plantes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plantes.model.Image;

public interface ImageRepository extends JpaRepository<Image, Long>{

}
