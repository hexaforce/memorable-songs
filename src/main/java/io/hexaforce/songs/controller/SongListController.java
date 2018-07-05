package io.hexaforce.songs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.hexaforce.songs.model.MusicItem;
import io.hexaforce.songs.model.SongListRequest;
import io.hexaforce.songs.service.SongListService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class SongListController {

	@Autowired
	private SongListService songListService;

	@GetMapping("/search-music-list/{year}")
	public ResponseEntity<List<MusicItem>> songListSearch2(@PathVariable("year") String year) {
		List<MusicItem> musicItemList = songListService.getMusicItemList();
		log.info("Year:{}", year);
		return new ResponseEntity<List<MusicItem>>(musicItemList, HttpStatus.OK);
	}
	

	@PostMapping("/search-music-list")
	public ResponseEntity<List<MusicItem>> songListSearch3(@RequestBody SongListRequest request) {
		List<MusicItem> musicItemList = songListService.getMusicItemList();
		log.info("searchWord:{}", request.getSearchWord());
		return new ResponseEntity<List<MusicItem>>(musicItemList, HttpStatus.OK);
	}
	
	
	
	
	@GetMapping("/song-list-1980")
	public ResponseEntity<List<MusicItem>> songList() {
		List<MusicItem> musicItemList = songListService.getMusicItemList();
		return new ResponseEntity<List<MusicItem>>(musicItemList, HttpStatus.OK);
	}

	@GetMapping("/song-list-search")
	public ResponseEntity<List<MusicItem>> songListSearch() {
		List<MusicItem> musicItemList = songListService.getMusicItemList();
		return new ResponseEntity<List<MusicItem>>(musicItemList, HttpStatus.OK);
	}

}
