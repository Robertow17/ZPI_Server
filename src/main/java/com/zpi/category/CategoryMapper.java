package com.zpi.category;


import org.mapstruct.*;
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

    Category toCategory(CategoryDTO categoryDTO);

    @InheritConfiguration
    List<CategoryDTO> toCategoryDTOs(List<Category> categories);
}
