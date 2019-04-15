package com.zpi.wedding_hall_details;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;


@Mapper(componentModel = "spring")
public interface WeddingHallDetailsMapper
{

    WeddingHallDetailsMapper INSTANCE = Mappers.getMapper(WeddingHallDetailsMapper.class);

    WeddingHallDetailsDTO toWeddingHallDTO(WeddingHallDetails weddingHallDetails);
    List<WeddingHallDetailsDTO> toWeddingHallDTOs(List<WeddingHallDetails> weddingHallDetails);
    WeddingHallDetails toWeddingHall(WeddingHallDetailsDTO weddingHallDetailsDTO);
}
