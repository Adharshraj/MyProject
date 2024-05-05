package com.project.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.tunehub.entity.Playlist;
import com.project.tunehub.entity.Song;
import com.project.tunehub.service.playlistService;
import com.project.tunehub.service.songService;
@Controller
public class playListController {
	@Autowired
	playlistService pls;
	@Autowired
	songService sgs;
	@PostMapping("addplay")
	public String addPlaylist(@ModelAttribute Playlist pl) {
		pls.addPlaylist(pl);
		List<Song> song=pl.getSong();
		for(Song sg : song) {
			sg.getPlaylist().add(pl);
			sgs.updateSong(sg);
		}
		return "playlistcreated";
	}
	@GetMapping("/createPlaylist")
	public String diaplaysongs(Model model) {
		List<Song> songlist = sgs.viewallsong();
		model.addAttribute("songlist", songlist);
		return "createplaylist";
		
	}
	@GetMapping("viewplaylist")
	public String viewPlaylist(Model model) {
		List<Playlist> pl=pls.viewPlaylist();
		model.addAttribute("playlist", pl);
		return "viewplaylistadmin";
	}
}
