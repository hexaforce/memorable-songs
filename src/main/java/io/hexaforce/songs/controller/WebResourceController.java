package io.hexaforce.songs.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
class WebResourceController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
    @GetMapping("/music-list")
    public String showSongList(Map<String, Object> model) {
//        Vets vets = new Vets();
//        vets.getVetList().addAll(this.vets.findAll());
//        model.put("vets", vets);
    	log.debug("music-list");
        return "music-list";
    }

    @GetMapping("/music-list2")
    public String showSongList2(Map<String, Object> model) {
    	log.debug("music-list2");
        return "music-list2";
    }
    
}
