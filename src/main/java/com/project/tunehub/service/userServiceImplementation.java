package com.project.tunehub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.tunehub.entity.User;
import com.project.tunehub.repository.userRepository;
@Service
public class userServiceImplementation implements userService{
	@Autowired
	userRepository urty;
	@Override
	public String adduser(User ur) {
		if(ur.getRole()=="admin") {
			ur.setPremium(true);
		}
		urty.save(ur);
		return "user created and saved";
	}
	@Override
	public boolean userExits(String email) {
		if(urty.findByEmail(email)==null) {
			return false;
		}
		else {
			return true;
		}
	}
	@Override
	public User findUser(String email) {
		User us=urty.findByEmail(email);
		return us;
	}
	@Override
	public boolean validate(String email) {
		User us=urty.findByEmail(email);
		if(us==null) {
			return false;
		}
		else {
			return true;
		}
		
	}
	@Override
	public void Updateuser(User us) {
		urty.save(us);
		
	}
	@Override
	public boolean userValidate(String email, String username) {
		User user=urty.findByEmail(email);
		if(user.getUsername().equals(username)) {
			return true;
		}
		else {
		return false;
		}
	}

}
