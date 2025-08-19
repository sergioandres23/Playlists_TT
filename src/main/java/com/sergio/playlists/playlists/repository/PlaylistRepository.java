package com.sergio.playlists.playlists.repository;


import com.sergio.playlists.playlists.models.entity.PlaylistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlaylistRepository extends JpaRepository<PlaylistEntity, Long> {

    Optional<PlaylistEntity> findByName(String name);
    void deleteByName(String name);
}
