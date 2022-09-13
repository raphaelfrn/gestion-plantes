package com.plantes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WishlistController {

	@GetMapping("/wishlist")
	public String getWishlist() {
		return "pages/wishlist";
	}
	
	@PostMapping("/wishlist")
	public String postWishlist() {
		return "pages/wishlist";
	}
}
