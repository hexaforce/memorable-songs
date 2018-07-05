package io.hexaforce.songs.service;

import java.util.List;
import java.util.Optional;

import io.hexaforce.songs.model.MusicItem;

public interface SongListService {

	public List<MusicItem> getMusicItemList();

	public List<MusicItem> getMusicItemList(String artist);
	
	public Optional<MusicItem> getMusicItem(Integer id);
	
}
