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
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
				try {
					MP3File mp3File = new MP3File(musicFile);
					MusicItem musicItem = null;
					// if (mp3File.hasID3v2Tag()) {
					// musicItem = new MusicItem(mp3File.getID3v2Tag());
					// }
					if (mp3File.hasID3v1Tag()) {
						musicItem = new MusicItem(mp3File.getID3v1Tag());
					}
					if (musicItem != null) {
						musicItem.setAbsolutePath(musicFile.getAbsolutePath());
						musicItem.setFileName(musicFile.getName());
						musicItemList.add(musicItem);
					}
				} catch (UnsupportedOperationException e) {
					log.error("### UnsupportedOperationException ### {}", musicFile);
				} catch (TagException e) {
					log.error("### TagException ### {}", musicFile);
				} catch (IOException e) {
					log.error("### IOException ### {}", musicFile);
				}
				
			}
		}

		if (!musicItemList.isEmpty()) {
			musicItemRepository.saveAll(musicItemList);
		}

	}

}
