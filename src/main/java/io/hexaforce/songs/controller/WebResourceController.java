package io.hexaforce.songs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class WebResourceController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
}
