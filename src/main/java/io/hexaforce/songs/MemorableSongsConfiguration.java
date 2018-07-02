package io.hexaforce.songs;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.farng.mp3.MP3File;
import org.farng.mp3.TagException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.hexaforce.songs.model.MusicItem;
import io.hexaforce.songs.model.MusicItemRepository;

@Configuration
@EnableConfigurationProperties(MemorableSongsProperties.class)
public class MemorableSongsConfiguration implements WebMvcConfigurer {

	@Autowired
	private MemorableSongsProperties memorableSongsProperties;
	
	@Autowired
	private MusicItemRepository musicItemRepository;
	
	@PostConstruct
	private void setupSongListDatabase() throws IOException, TagException {
		
		List<MusicItem> musicItemList = new ArrayList<MusicItem>();
		File topMusicDirectory = new File(memorableSongsProperties.getTopMusicDirectory());
		for (File musicDirectory : topMusicDirectory.listFiles()) {
			for (File musicFile : musicDirectory.listFiles()) {
				MP3File mp3File = new MP3File(musicFile);
				if (mp3File.hasID3v2Tag()) {
					musicItemList.add(new MusicItem(mp3File.getID3v2Tag()));
				} else if (mp3File.hasID3v1Tag()) {
					musicItemList.add(new MusicItem(mp3File.getID3v1Tag()));
				}
			}
		}
		
		if (!musicItemList.isEmpty()) {
			musicItemRepository.saveAll(musicItemList);
		}
		
	}

}
