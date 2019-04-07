package com.zpi.category;

import com.zpi.service.Service;
import com.zpi.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity create(@Valid @RequestBody Category category)
    {
        return ResponseEntity.ok(categoryService.save(category));
    }


    @GetMapping("/all")
    public ResponseEntity<List<Category>> getAll()
    {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable(value = "id") int id)
    {
        Optional<Category> category = categoryService.findById(id);
        if(!category.isPresent())
        {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(category.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable(value = "id") int id, @Valid @RequestBody Category category)
    {
        if(!categoryService.findById(id).isPresent())
        {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(categoryService.save(category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") int id)
    {
        if(!categoryService.findById(id).isPresent())
        {
            ResponseEntity.badRequest().build();
        }

        categoryService.deleteById(id);

        return ResponseEntity.ok().build();
    }


}
