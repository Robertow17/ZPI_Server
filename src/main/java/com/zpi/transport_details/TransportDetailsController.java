package com.zpi.transport_details;

import com.zpi.category.Category;
import com.zpi.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/transport/details")
public class TransportDetailsController
{

    @Autowired
    private TransportDetailsService transportDetailsService;


    @PostMapping
    public ResponseEntity create(@Valid @RequestBody TransportDetails transportDetails)
    {
        return ResponseEntity.ok(transportDetailsService.save(transportDetails));
    }


    @GetMapping("/all")
    public ResponseEntity<List<TransportDetails>> getAll()
    {
        return ResponseEntity.ok(transportDetailsService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransportDetails> findById(@PathVariable(value = "id") int id)
    {
        Optional<TransportDetails> transportDetails = transportDetailsService.findById(id);
        if(!transportDetails.isPresent())
        {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(transportDetails.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransportDetails> update(@PathVariable(value = "id") int id, @Valid @RequestBody TransportDetails transportDetails)
    {
        if(!transportDetailsService.findById(id).isPresent())
        {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(transportDetailsService.save(transportDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") int id)
    {
        if(!transportDetailsService.findById(id).isPresent())
        {
            ResponseEntity.badRequest().build();
        }

        transportDetailsService.deleteById(id);

        return ResponseEntity.ok().build();
    }


}
