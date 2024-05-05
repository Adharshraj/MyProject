package com.project.tunehub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.tunehub.entity.Song;
import com.project.tunehub.repository.songRepository;
@Service
public class songServiceImplementation implements songService{
	@Autowired
	songRepository srty;
	@Override
	public String addsongs(Song song) {
		srty.save(song);
		return "song added to database";
	}
	public boolean Validatesong(String name) {
		if(srty.findByname(name)==null) {
			return true;
		}
		else {
			return false;
		}
	}
	@Override
	public List<Song> viewallsong() {
		List<Song> sg=srty.findAll();
		return sg;
	}
	@Override
	public void updateSong(Song sg) {
		srty.save(sg);
		
	}

}
