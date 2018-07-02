package io.hexaforce.songs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.hexaforce.songs.model.MusicItem;
import io.hexaforce.songs.service.SongListService;

@RestController
public class SongListController {

	@Autowired
	private SongListService songListService;

	@GetMapping("/song-list-1980")
	public ResponseEntity<List<MusicItem>> songList() {
		
		List<MusicItem> musicItemList = songListService.getMusicItemList();
		
		return new ResponseEntity<List<MusicItem>>(musicItemList, HttpStatus.OK);
		
	}

}
