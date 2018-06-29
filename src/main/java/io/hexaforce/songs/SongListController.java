package io.hexaforce.songs;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SongListController {
	
    @GetMapping("/song-list.html")
    public String showVetList(Map<String, Object> model) {
//        Vets vets = new Vets();
//        vets.getVetList().addAll(this.vets.findAll());
//        model.put("vets", vets);
        return "vets/vetList";
    }
    
}
