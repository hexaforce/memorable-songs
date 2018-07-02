package io.hexaforce.songs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.hexaforce.songs.common.SongListUtile;
import io.hexaforce.songs.model.MusicItemRepository;

@Service
public class SongListServiceImpl implements SongListService {
	
	@Autowired
	private MusicItemRepository musicItemRepository;
	
	@Autowired
	private SongListUtile songListUtile;
	
}
