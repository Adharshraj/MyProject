package com.project.tunehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.tunehub.entity.User;

public interface userRepository extends JpaRepository<User, Integer>{
	public User findByEmail(String email);
}
