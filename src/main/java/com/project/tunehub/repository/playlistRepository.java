package com.project.tunehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.tunehub.entity.Playlist;

public interface playlistRepository extends JpaRepository<Playlist, Integer>{

}
