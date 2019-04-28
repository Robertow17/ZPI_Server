package com.zpi.service;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ServiceMapper
{

    ServiceMapper INSTANCE = Mappers.getMapper(ServiceMapper.class);


    @Mappings({
            @Mapping(target="id", source="id"),
            @Mapping(target="name", source="name"),
            @Mapping(target="localization", source="localization"),
            @Mapping(target="description", source="description"),
            @Mapping(target="phoneNumber", source="phoneNumber"),
            @Mapping(target="email", source="email"),
            @Mapping(target="category", source="category"),
            @Mapping(target="subcategory", source="subcategory"),
            @Mapping(target="weddingHallDetails", source="weddingHallDetails"),
            @Mapping(target="transportDetails", source="transportDetails"),
            @Mapping(target="photos", source="photos")
    })
    ServiceDTO toServiceDTO(Service service);


    List<ServiceDTO> toServiceDTOs(List<Service> services);

    @InheritInverseConfiguration
    Service toService(ServiceDTO serviceDTO);


}