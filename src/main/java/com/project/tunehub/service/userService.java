package com.project.tunehub.service;

import com.project.tunehub.entity.User;

public interface userService {
	public String adduser(User ur);
	public boolean userExits(String email);
	public User findUser(String email);
	public boolean validate(String email);
	public void Updateuser(User us);
	public boolean userValidate(String email,String username);
}
