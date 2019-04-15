package com.zpi.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/categories")
public class CategoryController
{
    @Autowired
    private CategoryService categoryService;


    @PostMapping
    public ResponseEntity<CategoryDTO> create(@Valid @RequestBody CategoryDTO categoryDTO)
    {
        categoryService.save(CategoryMapper.INSTANCE.toCategory(categoryDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryDTO);
    }


    @GetMapping("/all")
    public ResponseEntity<List<CategoryDTO>> getAll()
    {
        return ResponseEntity.ok(CategoryMapper.INSTANCE.toCategoryDTOs(categoryService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> findById(@PathVariable(value = "id") String id)
    {
        Optional<Category> category = categoryService.findById(id);

        if(!category.isPresent())
        {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(CategoryMapper.INSTANCE.toCategoryDTO(category.get()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> update(@PathVariable(value = "id") String id, @Valid @RequestBody CategoryDTO categoryDTO)
    {
        Category category = CategoryMapper.INSTANCE.toCategory(categoryDTO);
        category.setName(id);
        categoryService.save(category);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(categoryDTO);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") String id)
    {
        categoryService.deleteById(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }


}



















