package com.zpi.subcategory;

import com.zpi.category.Category;
import com.zpi.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/subcategories")
public class SubcategoryController
{

    @Autowired
    private SubcategoryService subcategoryService;


    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Subcategory subcategory)
    {
        return ResponseEntity.ok(subcategoryService.save(subcategory));
    }


    @GetMapping("/all")
    public ResponseEntity<List<Subcategory>> getAll()
    {
        return ResponseEntity.ok(subcategoryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subcategory> findById(@PathVariable(value = "id") int id)
    {
        Optional<Subcategory> subcategory = subcategoryService.findById(id);
        if(!subcategory.isPresent())
        {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(subcategory.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Subcategory> update(@PathVariable(value = "id") int id, @Valid @RequestBody Subcategory subcategory)
    {
        if(!subcategoryService.findById(id).isPresent())
        {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(subcategoryService.save(subcategory));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") int id)
    {
        if(!subcategoryService.findById(id).isPresent())
        {
            ResponseEntity.badRequest().build();
        }

        subcategoryService.deleteById(id);

        return ResponseEntity.ok().build();
    }

}
