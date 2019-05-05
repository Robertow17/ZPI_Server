package com.zpi.photo;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PhotoMapper {
    PhotoMapper INSTANCE = Mappers.getMapper(PhotoMapper.class);

    @Mappings({
            @Mapping(target = "id", source = "id"),
    })
    PhotoDTO toPhotoDTO(Photo photo);

    List<PhotoDTO> toPhotoDTOs(List<Photo> photos);
    Photo toPhoto(PhotoDTO photoDTO);
}
