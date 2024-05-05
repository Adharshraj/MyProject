package com.project.tunehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.tunehub.entity.Song;

public interface songRepository extends JpaRepository<Song, Integer>{
	public Song findByname(String name);
}
