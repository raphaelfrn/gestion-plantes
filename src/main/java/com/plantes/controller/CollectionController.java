package com.plantes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CollectionController {

	@GetMapping("/collection")
	public String getCollection() {
		return "pages/collection";
	}
	
	@PostMapping("/collection")
	public String postCollection() {
		return "pages/collection";
	}
	
}
