package com.sergio.playlists.playlists.models.dto;

import lombok.Data;


@Data
public class SongDTO {

    private String title;
    private String artist;
    private String album;
    private Long year;
    private String genre;

}
