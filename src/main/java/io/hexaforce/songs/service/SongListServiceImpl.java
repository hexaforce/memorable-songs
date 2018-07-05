package io.hexaforce.songs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.hexaforce.songs.model.MusicItem;
import io.hexaforce.songs.model.MusicItemRepository;

@Service
public class SongListServiceImpl implements SongListService {

	@Autowired
	private MusicItemRepository musicItemRepository;

//	@Autowired
//	private SongListUtile songListUtile;

	@Override
	public List<MusicItem> getMusicItemList() {
		List<MusicItem> musicItemList = musicItemRepository.findAll();
		return musicItemList;
	}

	@Override
	public List<MusicItem> getMusicItemList(String artist) {
		List<MusicItem> musicItemList = musicItemRepository.findByArtistContaining(artist);
		return musicItemList;
	}

	public Optional<MusicItem> getMusicItemList(Integer id) {
		return musicItemRepository.findById(id);
	}
	
	
}
