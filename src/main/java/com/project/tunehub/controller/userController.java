package com.project.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.tunehub.entity.Playlist;
import com.project.tunehub.entity.Song;
import com.project.tunehub.entity.User;
import com.project.tunehub.service.playlistService;
import com.project.tunehub.service.songService;
import com.project.tunehub.service.userService;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class userController {
	@Autowired
	userService usvc;
	@Autowired
	songService svs;
	@Autowired
	playlistService pls;
	
	@PostMapping("register")
	public String adduser(User ur) {
		if(usvc.userExits(ur.getEmail())) {
			System.out.println("User already exits");
			return "Registerfail";
		}
		else {
			String msg=usvc.adduser(ur);
			return "Registersuccess";
		}
	}
	@PostMapping("login")
	public String userLogin(@RequestParam String email,@RequestParam String password, HttpSession session,Model model) {
		if(usvc.validate(email)) {
		session.setAttribute("email", email);
		User se=usvc.findUser(email);
		model.addAttribute("username", se.getUsername());
		if(se.getPassword().equals(password)) {
			if(se.getRole().equals("admin")) {
				return "Adminhome";
			}
			else {
				return "Customerhome";
			}
		}
		else {
		return "Unsuccess";
		}
		}
		else {
			return "Usernotexist";
		}
		
	}
	@GetMapping("exploresongs")
	public String expolresong(HttpSession session,Model model) {
		String email=(String) session.getAttribute("email");
		User us=usvc.findUser(email);
		if(us.isPremium()==true) {
			List<Song> songlist=svs.viewallsong();
			model.addAttribute("songlist", songlist);
			return "Displaysonguser";
		}
		else {
		return "Testpayment";
		}
	}
	@GetMapping("exploreplaylist")
	public String explorePlaylist(HttpSession session,Model model) {
		String email=(String) session.getAttribute("email");
		User us=usvc.findUser(email);
		if(us.isPremium()==true) {
			List<Playlist> pl=pls.viewPlaylist();
			model.addAttribute("playlist", pl);
			return "viewplaylist";
		}
		else {
		return "Testpayment";
		}
	}
	@GetMapping("createuserPlaylist")
	public String createPlayList(HttpSession session,Model model) {
		String email=(String) session.getAttribute("email");
		User us=usvc.findUser(email);
		if(us.isPremium()==true) {
			List<Song> songlist = svs.viewallsong();
			model.addAttribute("songlist", songlist);
			return "createplaylist";
		}
		else {
		return "Testpayment";
		}
	}
	@PostMapping("restpsw")
	public String resetPws(@RequestParam String email,@RequestParam String username,@RequestParam String ps1,@RequestParam String ps2) {
		if(usvc.validate(email)) {
			if(usvc.userValidate(email, username)) {
				User us=usvc.findUser(email);
				if(ps1.equals(ps2)) {
				us.setPassword(ps1);
				usvc.Updateuser(us);
				return "login";
				}
				else {
					return "passwordmismatch";
				}
			}
			else {
				return "pswresetfailed";
			}
		}
		else {
			return "pswresetfailed";
		}
	}
	
	
	
}
