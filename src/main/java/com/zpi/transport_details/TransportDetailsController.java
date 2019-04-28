package com.zpi.transport_details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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


    @PostMapping("/add")
    public ResponseEntity<TransportDetailsDTO> create(@Valid @RequestBody TransportDetailsDTO transportDetailsDTO)
    {
        transportDetailsService.save(TransportDetailsMapper.INSTANCE.toTransportDetails(transportDetailsDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(transportDetailsDTO);
    }


    @GetMapping("/all")
    public ResponseEntity<List<TransportDetailsDTO>> getAll()
    {
        return ResponseEntity.ok(TransportDetailsMapper.INSTANCE.toTransportDetailsDTOs(transportDetailsService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransportDetailsDTO> findById(@PathVariable(value = "id") int id)
    {
        Optional<TransportDetails> transportDetails = transportDetailsService.findById(id);
        if(!transportDetails.isPresent())
        {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(TransportDetailsMapper.INSTANCE.toTransportDetailsDTO(transportDetails.get()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransportDetailsDTO> update(@PathVariable(value = "id") int id, @Valid @RequestBody TransportDetailsDTO transportDetailsDTO)
    {
        TransportDetails transportDetails = TransportDetailsMapper.INSTANCE.toTransportDetails(transportDetailsDTO);
        transportDetails.setId(id);
        transportDetailsService.save(transportDetails);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(transportDetailsDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") int id)
    {
        transportDetailsService.deleteById(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }


}
