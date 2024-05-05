package com.project.tunehub.service;

import java.util.List;

import com.project.tunehub.entity.Playlist;

public interface playlistService {
	public String addPlaylist(Playlist pl);

	public List<Playlist> viewPlaylist();
}
