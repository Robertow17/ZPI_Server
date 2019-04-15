package com.zpi.category;


import com.zpi.subcategory.SubcategoryDTO;
import lombok.Data;

import java.util.List;

@Data
public class CategoryDTO
{
    private String name;
    private List<SubcategoryDTO> subcategories;

}
