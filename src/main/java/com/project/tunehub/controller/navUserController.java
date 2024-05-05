package com.project.tunehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.tunehub.entity.User;
import com.project.tunehub.service.userService;

import jakarta.servlet.http.HttpSession;
@Controller
public class navUserController {
	@Autowired
	userService usvc;
	@GetMapping("regWire")
	public String  registerMap() {
		return "register";
	}
	@GetMapping("MapLog")
	public String mapLogin() {
		return "login";
	}
	@GetMapping("/mapadd")
	public String mapaddsong() {
		return "addsongs";
	}
	@GetMapping("testpay")
	public String testpay() {
		return "Testpayment";
	}
	@GetMapping("Logout")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "login";
	}
	@GetMapping("forgot")
	public String forgot() {
		return "forgotpsw";
	}
	@GetMapping("Homepage")
	public String userHone(HttpSession session,Model model) {
		String email=(String) session.getAttribute("email");
		User se=usvc.findUser(email);
		model.addAttribute("username", se.getUsername());
		return "Customerhome";
	}
	@GetMapping("Adminhome")
	public String adminhome(HttpSession session,Model model) {
		String email=(String) session.getAttribute("email");
		User se=usvc.findUser(email);
		model.addAttribute("username", se.getUsername());
		return "Adminhome";
	}
}
