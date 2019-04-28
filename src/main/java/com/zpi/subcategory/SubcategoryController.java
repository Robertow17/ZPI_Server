package com.zpi.subcategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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


    @PostMapping("/add")
    public ResponseEntity<SubcategoryDTO> create(@Valid @RequestBody SubcategoryDTO subcategoryDTO)
    {
        subcategoryService.save(SubcategoryMapper.INSTANCE.toSubcategory(subcategoryDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(subcategoryDTO);
    }


    @GetMapping("/all")
    public ResponseEntity<List<SubcategoryDTO>> getAll()
    {
        return ResponseEntity.ok(SubcategoryMapper.INSTANCE.toSubcategoryDTOs(subcategoryService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubcategoryDTO> findById(@PathVariable(value = "id") String id)
    {
        Optional<Subcategory> subcategory = subcategoryService.findById(id);

        if(!subcategory.isPresent())
        {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(SubcategoryMapper.INSTANCE.toSubcategoryDTO(subcategory.get()));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<SubcategoryDTO> update(@PathVariable(value = "id") String id, @Valid @RequestBody SubcategoryDTO subcategoryDTO)
    {
        Subcategory subcategory = SubcategoryMapper.INSTANCE.toSubcategory(subcategoryDTO);
        subcategory.setName(id);
        subcategoryService.save(subcategory);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(subcategoryDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") String id)
    {
        subcategoryService.deleteById(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
