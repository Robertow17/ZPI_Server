package com.zpi.favourite;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FavouriteMapper
{
    FavouriteMapper INSTANCE = Mappers.getMapper(FavouriteMapper.class);


   @Mappings({
            @Mapping(target="favourite", source="favourite"),
           @Mapping(target="user", source="user"),
           @Mapping(target="service", source="service")
    })
    FavouriteDTO toFavouriteDTO(Favourite favourite);

    List<FavouriteDTO> toFavouriteDTOs(List<Favourite> favourites);

    @InheritInverseConfiguration
    Favourite toFavourite(FavouriteDTO favouriteDTO);

}
