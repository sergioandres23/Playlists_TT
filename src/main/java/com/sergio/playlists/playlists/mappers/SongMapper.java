package com.sergio.playlists.playlists.mappers;

import com.sergio.playlists.playlists.models.dto.SongDTO;
import com.sergio.playlists.playlists.models.entity.SongEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SongMapper {

    SongDTO toDto(SongEntity entity);

    SongEntity toEntity(SongDTO dto);

    List<SongDTO> toDtoList(List<SongEntity> entities);

    List<SongEntity> toEntityList(List<SongDTO> dtoList);
}
