package io.hexaforce.songs.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "music_item")
public class MusicItem extends BaseEntity {
	private String songTitle;
	private String albumTitle;
	private String track;
	private String artist;
}
