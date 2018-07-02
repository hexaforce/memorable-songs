package io.hexaforce.songs;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.farng.mp3.MP3File;
import org.farng.mp3.TagException;
import org.farng.mp3.id3.ID3v1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableConfigurationProperties(MemorableSongsProperties.class)
public class MemorableSongsConfiguration implements WebMvcConfigurer {

	@Autowired
	private MemorableSongsProperties memorableSongsProperties;

	@PostConstruct
	private void setupSongListDatabase() throws IOException, TagException {

		File topMusicDirectory = new File(memorableSongsProperties.getTopMusicDirectory());
		for (File musicDirectory : topMusicDirectory.listFiles()) {
			for (File musicFile : musicDirectory.listFiles()) {
				
				MP3File mp3File = new MP3File(musicFile);
				log.debug("mp3File:{}", mp3File);

				if (mp3File.hasFilenameTag()) {
					log.debug("FilenameTag:{}", mp3File.getFilenameTag());
				}

				if (mp3File.hasID3v1Tag()) {
					log.debug("ID3v1Tag:{}", mp3File.getID3v1Tag());
					ID3v1 tag = mp3File.getID3v1Tag();
					
					tag.getGenre();
					
					tag.getArtist();
					tag.getSongTitle();
					
					tag.getAlbumTitle();
					tag.getTrackNumberOnAlbum();
					
					tag.getYearReleased();
					

				}

				if (mp3File.hasID3v2Tag()) {
					log.debug("ID3v2Tag:{}", mp3File.getID3v2Tag());
				}

				if (mp3File.hasLyrics3Tag()) {
					log.debug("Lyrics3Tag:{}", mp3File.getLyrics3Tag());
				}
				
			}
		}
		
	}

}
