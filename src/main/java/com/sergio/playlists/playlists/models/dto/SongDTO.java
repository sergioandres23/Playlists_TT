package com.sergio.playlists.playlists.models.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class SongDTO {

    @NotBlank
    private String title;
    @NotBlank
    private String artist;
    private String album;
    private Long year;
    private String genre;

}
