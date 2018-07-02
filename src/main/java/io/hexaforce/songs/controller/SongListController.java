package io.hexaforce.songs.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.hexaforce.songs.model.MusicItem;
import io.hexaforce.songs.service.SongListService;

@RestController
public class SongListController {
	
	@Autowired
	private SongListService songListService;
	
	@GetMapping("/song-list")
	public ResponseEntity<List<MusicItem>> aaa() {
		return null;
	}
	
}
