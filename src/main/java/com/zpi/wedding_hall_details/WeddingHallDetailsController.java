package com.zpi.wedding_hall_details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<WeddingHallDetailsDTO> create(@Valid @RequestBody WeddingHallDetailsDTO weddingHallDetailsDTO)
    {
        weddingHallDetailsService.save(WeddingHallDetailsMapper.INSTANCE.toWeddingHall(weddingHallDetailsDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(weddingHallDetailsDTO);
    }


    @GetMapping("/all")
    public ResponseEntity<List<WeddingHallDetailsDTO>> getAll()
    {
        return ResponseEntity.ok(WeddingHallDetailsMapper.INSTANCE.toWeddingHallDTOs(weddingHallDetailsService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<WeddingHallDetailsDTO> findById(@PathVariable(value = "id") int id)
    {
        Optional<WeddingHallDetails> service = weddingHallDetailsService.findById(id);

        if(!service.isPresent())
        {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(WeddingHallDetailsMapper.INSTANCE.toWeddingHallDTO(service.get()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WeddingHallDetailsDTO> update(@PathVariable(value = "id") int id, @Valid @RequestBody WeddingHallDetailsDTO weddingHallDetailsDTO)
    {
        WeddingHallDetails weddingHallDetails = WeddingHallDetailsMapper.INSTANCE.toWeddingHall(weddingHallDetailsDTO);
        weddingHallDetails.setId(id);
        weddingHallDetailsService.save(weddingHallDetails);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(weddingHallDetailsDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") int id)
    {
        weddingHallDetailsService.deleteById(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }


}
