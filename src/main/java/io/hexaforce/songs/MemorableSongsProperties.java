package io.hexaforce.songs;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "spring.song", ignoreUnknownFields = true)
public class MemorableSongsProperties {
	private String songDirectory;
}
