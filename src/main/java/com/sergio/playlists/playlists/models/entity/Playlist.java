package com.sergio.playlists.playlists.models.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Playlist {

    @Id
    private String name;

    private String description;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "playlist_nombre")
    private List<Song> songs = new ArrayList<Song>();







}
