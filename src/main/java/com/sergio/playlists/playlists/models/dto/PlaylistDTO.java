package com.sergio.playlists.playlists.models.dto;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PlaylistDTO {

    private String name;
    private String description;
    private List<SongDTO> songs = new ArrayList<>();

}
