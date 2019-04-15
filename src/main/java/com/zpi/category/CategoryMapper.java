package com.zpi.category;


import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper
{
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);


    @Mappings({
            @Mapping(target="name", source="name"),
            @Mapping(target="subcategories", source="subcategories")
    })
    CategoryDTO toCategoryDTO(Category category);

    @InheritInverseConfiguration
    Category toCategory(CategoryDTO categoryDTO);


    List<CategoryDTO> toCategoryDTOs(List<Category> categories);
}
