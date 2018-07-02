package io.hexaforce.songs.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import io.hexaforce.songs.service.SongListService;

@Controller
public class SongListController {
	
	@Autowired
	private SongListService songListService;
	
	public String aaa() {
		return null;
	}
	
	
    @GetMapping("/song-list.html")
    public String showSongList(Map<String, Object> model) {
//        Vets vets = new Vets();
//        vets.getVetList().addAll(this.vets.findAll());
//        model.put("vets", vets);
        return "song-list";
    }
    
}
