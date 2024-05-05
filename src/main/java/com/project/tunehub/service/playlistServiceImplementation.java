package com.project.tunehub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.tunehub.entity.Playlist;
import com.project.tunehub.repository.playlistRepository;
@Service
public class playlistServiceImplementation implements playlistService{
	@Autowired
	playlistRepository plr;
	@Override
	public String addPlaylist(Playlist pl) {
		plr.save(pl);
		return "song added to playlist";
	}
	@Override
	public List<Playlist> viewPlaylist() {
		List<Playlist> plst=plr.findAll();
		return plst;
	}

}
