package com.sergio.playlists.playlists.service;

import com.sergio.playlists.playlists.models.entity.PlaylistEntity;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlaylistsService {

    @Transactional
    PlaylistEntity createPlaylist (PlaylistEntity playlistEntity);

    @Transactional
    List<PlaylistEntity> getAllPlaylists();

    @Transactional
    PlaylistEntity getPlaylist(String name);

    @Transactional
    void deletePlaylist(String name);


}
