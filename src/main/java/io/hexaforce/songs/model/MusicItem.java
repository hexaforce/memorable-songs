package io.hexaforce.songs.model;

import java.io.UnsupportedEncodingException;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.farng.mp3.id3.AbstractID3v2;
import org.farng.mp3.id3.ID3v1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Table(name = "music_item")
public class MusicItem extends BaseEntity {

	private String album;
	private String artist;
	private String comment;
	private String title;
	private String year;
	private Integer track;
	
	private String fileName;
	private String absolutePath;
	private String download;
	
	//private String genre;

	public MusicItem(ID3v1 tag) {
		this.album = convert(tag.getAlbumTitle());
		this.artist = convert(tag.getArtist());
		this.comment = convert(tag.getComment());
		this.title = convert(tag.getTitle());
		this.year = convert(tag.getYear());
		this.track = Integer.parseInt(tag.getTrackNumberOnAlbum());
		//this.genre = Byte.toString(tag.getGenre());
	}

	public MusicItem(AbstractID3v2 tag) {
		this.album = convert(tag.getAlbumTitle());
		this.artist = convert(tag.getLeadArtist());
		this.comment = convert(tag.getSongComment());
		this.title = convert(tag.getSongTitle());
		this.year = convert(tag.getYearReleased());
		this.track = Integer.parseInt(tag.getTrackNumberOnAlbum());
		//this.genre = tag.getSongGenre();
	}
	
	private String convert(String x) {
		try {
			return new String (x.getBytes("ISO-8859-1"), "Shift_JIS");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return x;
	}
	
}
