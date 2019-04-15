package com.zpi.favourite;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FavouriteMapper
{
    FavouriteMapper INSTANCE = Mappers.getMapper(FavouriteMapper.class);


    @Mappings({
            @Mapping(target="id", source="id"),
            @Mapping(target="favourite", source="favourite"),
    })
    FavouriteDTO toFavouriteDTO(Favourite favourite);
    List<FavouriteDTO> toFavouriteDTOs(List<Favourite> favourites);

    @InheritInverseConfiguration
    Favourite toFavourite(FavouriteDTO favouriteDTO);

}
