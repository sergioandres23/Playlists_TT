package com.sergio.playlists.playlists.controller;

import com.sergio.playlists.playlists.mappers.PlaylistMapper;
import com.sergio.playlists.playlists.models.dto.PlaylistDTO;
import com.sergio.playlists.playlists.service.PlaylistsService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/lists")
public class PlaylistController {

    private final PlaylistsService playlistsService;
    private final PlaylistMapper playlistMapper;

    public PlaylistController(PlaylistsService playlistsService, PlaylistMapper playlistMapper) {
        this.playlistsService = playlistsService;
        this.playlistMapper = playlistMapper;
    }

    @PostMapping
    public ResponseEntity<PlaylistDTO> createPlaylist(@Valid @RequestBody PlaylistDTO dto) {
        var entity = playlistMapper.toEntity(dto);
        var saved = playlistsService.createPlaylist(entity);
        return ResponseEntity
                .created(URI.create("/lists/" + saved.getName()))
                .body(playlistMapper.toDto(saved));
    }

    @GetMapping
    public List<PlaylistDTO> getAllPlaylists() {
        return playlistMapper.toDtoList(playlistsService.getAllPlaylists());
    }

    @GetMapping("/{name}")
    public PlaylistDTO getPlaylist(@PathVariable String name) {
        return playlistMapper.toDto(playlistsService.getPlaylist(name));
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deletePlaylist(@PathVariable String name) {
        playlistsService.deletePlaylist(name);
        return ResponseEntity.noContent().build();
    }
}
