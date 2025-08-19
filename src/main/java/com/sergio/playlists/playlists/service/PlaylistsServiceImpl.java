package com.sergio.playlists.playlists.service;

import com.sergio.playlists.playlists.models.entity.PlaylistEntity;
import com.sergio.playlists.playlists.repository.PlaylistRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PlaylistsServiceImpl implements PlaylistsService{

    private final PlaylistRepository playlistRepository;

    public PlaylistsServiceImpl(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    @Override
    public PlaylistEntity createPlaylist(PlaylistEntity playlist) {

        String name = playlist.getName();
        if (name == null || name.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Playlist name cannot be null or empty");
        }
        if (playlistRepository.findByName(name).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Playlist already exists");
        }
        else {
            return playlistRepository.save(playlist);
        }
    }

    @Override
    public List<PlaylistEntity> getAllPlaylists() {
        return playlistRepository.findAll();
    }

    @Override
    public PlaylistEntity getPlaylist(String name) {

        if (name == null || name.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Playlist name cannot be null or empty");
        }
        return playlistRepository.findByName(name)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Playlist not found"));
    }

    @Override
    public void deletePlaylist(String name) {

        if (name == null || name.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Playlist name cannot be null or empty");
        }

        if (playlistRepository.findByName(name).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Playlist doesn't exists");
        }

        else {
            playlistRepository.deleteByName(name);
        }

    }

}
