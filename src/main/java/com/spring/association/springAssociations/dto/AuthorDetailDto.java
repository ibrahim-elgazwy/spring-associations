package com.spring.association.springAssociations.dto;

import java.io.Serializable;

public class AuthorDetailDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7307787410672513493L;

	private int id;
	
	private int rate;
	
	private String hobby;
	
	private String youtubeChannel;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}
	
}
