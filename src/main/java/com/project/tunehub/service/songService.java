package com.project.tunehub.service;

import java.util.List;

import com.project.tunehub.entity.Song;

public interface songService {
	public String addsongs(Song song);
	public boolean Validatesong(String name);
	public List<Song> viewallsong();
	public void updateSong(Song sg);
}
