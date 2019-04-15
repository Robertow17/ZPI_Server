package com.zpi.service;


import com.zpi.category.CategoryDTO;
import com.zpi.subcategory.SubcategoryDTO;
import com.zpi.transport_details.TransportDetailsDTO;
import com.zpi.wedding_hall_details.WeddingHallDetailsDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
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
            @Mapping(target="category", source="category.name"),
            @Mapping(target="subcategory", source="subcategory.name"),
            @Mapping(target="weddingHallDetails", source="weddingHallDetails"),
            @Mapping(target="transportDetails", source="transportDetails")
    })
    ServiceDTO toServiceDTO(Service service);
    List<ServiceDTO> toServiceDTOs(List<Service> services);

    @InheritInverseConfiguration
    Service toService(ServiceDTO serviceDTO);


}