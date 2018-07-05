package io.hexaforce.songs.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import io.hexaforce.songs.model.MusicItem;
import io.hexaforce.songs.service.SongListService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
class WebResourceController {

	@Autowired
	private SongListService songListService;

	@GetMapping("/")
	public String index(Map<String, Object> model) {
		List<MusicItem> musicItemList = songListService.getMusicItemList();
		model.put("musicItemList", musicItemList);
		log.debug("index");
		return "index";
	}

	@GetMapping("/sidebar-menu-item")
	public List<MusicItem> sidebarMenuItem() {
		List<MusicItem> musicItemList = songListService.getMusicItemList();
		return musicItemList;
	}

	@GetMapping("/music-list")
	public String showSongList(Map<String, Object> model) {

		List<MusicItem> musicItemList = songListService.getMusicItemList();
		model.put("musicItemList", musicItemList);

		//List<String> menuItemList = musicItemList.stream().map(x -> x.getArtist()).distinct().collect(Collectors.toList());
		//model.put("musicItemList", menuItemList);

		log.debug("music-list");

		return "music-list";
	}

}
