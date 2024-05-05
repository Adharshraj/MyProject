package com.project.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.tunehub.entity.Song;
import com.project.tunehub.service.songService;



@Controller
public class songController {
	@Autowired
	songService ssvc;
	@PostMapping("/addsongs")
	public String addsongs(@ModelAttribute Song song) {
		if(ssvc.Validatesong(song.getName())) {
		String msg=ssvc.addsongs(song);
		System.out.println("Song added");
		return "Adminhome";
	}
		else {
			return "addsongfailed";
		}
	}
	@GetMapping("/viewallsongs")
	public String viewallsongs(Model model){
		List<Song> songlist = ssvc.viewallsong();
		model.addAttribute("songlist", songlist);
		return "displaysong";
	}
	@GetMapping("viewsongs")
	public String viewsongs(Model model) {
		boolean primeuser=true;
		if(primeuser==true) {
		List<Song> songlist = ssvc.viewallsong();
		model.addAttribute("songlist", songlist);
		return "displaysong";
	}
		else {
			return "makepayment";
		}
	}
}
