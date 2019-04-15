package com.zpi.subcategory;


import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubcategoryMapper
{

    SubcategoryMapper INSTANCE = Mappers.getMapper(SubcategoryMapper.class);

    @Mappings({
            @Mapping(target="name", source="name")
    })
    SubcategoryDTO toSubcategoryDTO(Subcategory subcategory);

    @InheritInverseConfiguration
    Subcategory toSubcategory(SubcategoryDTO subcategoryDTO);

    List<SubcategoryDTO> toSubcategoryDTOs(List<Subcategory> subcategories);
}
