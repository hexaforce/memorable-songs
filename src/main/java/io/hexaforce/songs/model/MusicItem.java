package io.hexaforce.songs.model;

import lombok.Data;

@Data
public class MusicItem extends BaseEntity {
	private String songTitle;
	private String albumTitle;
	private String track;
	private String artist;
}
