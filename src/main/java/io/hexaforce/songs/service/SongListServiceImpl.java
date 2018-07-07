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
	public List<MusicItem> getYearReleasedMusicItemList(String released) {
		List<MusicItem> musicItemList = musicItemRepository.findByYearReleased(released);
		return musicItemList;
	}

	@Override
	public List<MusicItem> getArtistContainingMusicItemList(String artist) {
		List<MusicItem> musicItemList = musicItemRepository.findByArtistContaining(artist);
		return musicItemList;
	}

	@Override
	public Optional<MusicItem> getMusicItem(Integer id) {
		return musicItemRepository.findById(id);
	}
	
	
}
