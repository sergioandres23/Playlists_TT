package com.sergio.playlists.playlists.repository;


import com.sergio.playlists.playlists.models.entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
}
