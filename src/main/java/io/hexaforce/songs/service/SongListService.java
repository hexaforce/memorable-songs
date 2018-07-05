package io.hexaforce.songs.service;

import java.util.List;

import io.hexaforce.songs.model.MusicItem;

public interface SongListService {

	public List<MusicItem> getMusicItemList();
	
	public List<MusicItem> getMusicItemList(String artist);
	
}
