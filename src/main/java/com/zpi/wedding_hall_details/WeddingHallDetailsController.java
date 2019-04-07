package com.zpi.wedding_hall_details;

import com.zpi.category.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/wedding/hall/details")
public class WeddingHallDetailsController
{
    @Autowired
    private WeddingHallDetailsService weddingHallDetailsService;


    @PostMapping
    public ResponseEntity create(@Valid @RequestBody WeddingHallDetails weddingHallDetails)
    {
        return ResponseEntity.ok(weddingHallDetailsService.save(weddingHallDetails));
    }


    @GetMapping("/all")
    public ResponseEntity<List<WeddingHallDetails>> getAll()
    {
        return ResponseEntity.ok(weddingHallDetailsService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WeddingHallDetails> findById(@PathVariable(value = "id") int id)
    {
        Optional<WeddingHallDetails> weddingHallDetails = weddingHallDetailsService.findById(id);
        if(!weddingHallDetails.isPresent())
        {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(weddingHallDetails.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<WeddingHallDetails> update(@PathVariable(value = "id") int id, @Valid @RequestBody WeddingHallDetails weddingHallDetails)
    {
        if(!weddingHallDetailsService.findById(id).isPresent())
        {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(weddingHallDetailsService.save(weddingHallDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") int id)
    {
        if(!weddingHallDetailsService.findById(id).isPresent())
        {
            ResponseEntity.badRequest().build();
        }

        weddingHallDetailsService.deleteById(id);

        return ResponseEntity.ok().build();
    }

}
