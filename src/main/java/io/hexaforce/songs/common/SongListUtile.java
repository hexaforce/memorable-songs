package io.hexaforce.songs.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.hexaforce.songs.MemorableSongsProperties;

@Component
public class SongListUtile {

	@Autowired
	private MemorableSongsProperties memorableSongsProperties;
	
	public void aaa() {
		memorableSongsProperties.getTopMusicDirectory();
	}
	
}
