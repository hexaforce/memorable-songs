package io.hexaforce.songs.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class WebResourceController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
    @GetMapping("/song-list.html")
    public String showSongList(Map<String, Object> model) {
//        Vets vets = new Vets();
//        vets.getVetList().addAll(this.vets.findAll());
//        model.put("vets", vets);
        return "song-list";
    }
    
}
