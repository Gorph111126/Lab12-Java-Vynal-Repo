package edu.cscc.Lab12.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

/*
 * @author Alexnader Granville
 * @version 4/16/24
 */

@Entity
public class VinalRecord{

	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private long id;
	@Min(value=1930, message="Please enter a date after 1930")
	private long released;
	@Min(value=1,message="Must have at least 1 song")
	@Max(value=20, message="Please enter a number less than 20")
	private long numTracks;
	private long size;
	@NotEmpty
	@Size(min=1,message="Must be at least 1 character")
	@Size(max=50, message="Must not be more than 50 characters")
	private String title;
	@NotEmpty
	@Size(min=1,message="Must be at least 1 character")
	@Size(max=40, message="Must not be more than 40 characters")
	private String artist;
	@NotEmpty
	@Size(min=1,message="Must be at least 1 character")
	@Size(max=40, message="Must not be more than 40 characters")
	private String label;
	
	private boolean damaged;
	
	public String getLabel() {
		return label;
	}

	public long getReleased() {
		return released;
	}

	public void setReleased(long released) {
		this.released = released;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public long getNumTracks() {
		return numTracks;
	}

	public void setNumTracks(long numTracks) {
		this.numTracks = numTracks;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public boolean isDamaged() {
		return damaged;
	}

	public void setDamaged(boolean damaged) {
		this.damaged = damaged;
	}


	
	
	//ALT+SHIFT+S auto getter and setter Hover over specific property
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	

	public VinalRecord() {}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}
}
