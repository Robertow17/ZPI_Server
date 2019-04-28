package com.zpi.subcategory;


import org.mapstruct.*;
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

    Subcategory toSubcategory(SubcategoryDTO subcategoryDTO);

    @InheritConfiguration
    List<SubcategoryDTO> toSubcategoryDTOs(List<Subcategory> subcategories);
}
