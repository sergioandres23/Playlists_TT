package com.sergio.playlists.playlists.models.dto;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PlaylistDTO {

    @NotBlank
    private String name;
    private String description;
    @Valid
    private List<SongDTO> songs;

}
