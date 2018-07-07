package io.hexaforce.songs.service;

import java.util.List;
import java.util.Optional;

import io.hexaforce.songs.model.MusicItem;

public interface SongListService {

	public List<MusicItem> getYearReleasedMusicItemList(String released);

	public List<MusicItem> getArtistContainingMusicItemList(String searchWord);
	
	public Optional<MusicItem> getMusicItem(Integer id);
	
}
