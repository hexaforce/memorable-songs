package io.hexaforce.songs;

import java.io.File;

import javax.annotation.PostConstruct;

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
	private void setupSongListDatabase() {

		File topMusicDirectory = new File(memorableSongsProperties.getTopMusicDirectory());
		for (File musicDirectory : topMusicDirectory.listFiles()) {
			for (File musicItem : musicDirectory.listFiles()) {
				log.debug("musicItem:{}", musicItem);
			}
		}
		
	}

}
