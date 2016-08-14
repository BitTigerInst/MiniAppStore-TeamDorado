package org.bittiger.group5.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;



@JsonIgnoreProperties(ignoreUnknown = true)
@Document(indexName = "app", type = "app", shards = 1, replicas = 0)
public class App {
	@Id
	private Long trackId;
	private Long artistId;
	private String artistName;
	private String description;
	private String artworkUrl100;
	private List<Integer> genreIds;
	private List<String> genres;
	private double averageUserRating;
	private String trackCensoredName;

	public Long getTrackId() {
		return trackId;
	}

	public void setTrackId(Long trackId) {
		this.trackId = trackId;
	}

	public Long getArtistId() {
		return artistId;
	}

	public void setArtistId(Long artistId) {
		this.artistId = artistId;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Integer> getGenreIds() {
		return genreIds;
	}

	public void setGenreIds(List<Integer> genreIds) {
		this.genreIds = genreIds;
	}

	public List<String> getGenres() {
		return genres;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	public double getAverageUserRating() {
		return averageUserRating;
	}

	public void setAverageUserRating(double averageUserRating) {
		this.averageUserRating = averageUserRating;
	}

	public String getTrackCensoredName() {
		return trackCensoredName;
	}

	public void setTrackCensoredName(String trackCensoredName) {
		this.trackCensoredName = trackCensoredName;
	}

	public String getArtworkUrl100() {
		return artworkUrl100;
	}

	public void setArtworkUrl100(String artworkUrl100) {
		this.artworkUrl100 = artworkUrl100;
	}
}