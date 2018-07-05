package io.hexaforce.songs.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
		List<MusicItem> musicItemList = songListService.getMusicItemList(request.getSearchWord());
		log.info("searchWord:{}", request.getSearchWord());
		return new ResponseEntity<List<MusicItem>>(musicItemList, HttpStatus.OK);
	}

	@GetMapping("/download-music/{id}")
	public ResponseEntity<InputStreamResource> downloadMusic(@PathVariable("id") String id) throws FileNotFoundException, UnsupportedEncodingException {
		
		List<MusicItem> musicItemList = songListService.getMusicItemList();
		log.info("id:{}", id);
		MusicItem musicItem = musicItemList.get(0);
		String downloadFileName = musicItem.getArtist();
		
		InputStreamResource downloadResource = new InputStreamResource(new FileInputStream(downloadFileName));
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE);
		headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename*=UTF-8''" + URLEncoder.encode(downloadFileName, StandardCharsets.UTF_8.name()));
		return new ResponseEntity<InputStreamResource>(downloadResource, headers, HttpStatus.OK);
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
