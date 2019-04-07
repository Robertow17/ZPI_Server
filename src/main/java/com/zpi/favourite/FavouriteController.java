package com.zpi.favourite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/favourites")
public class FavouriteController
{
    @Autowired
    private FavouriteService favouriteService;


    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Favourite favourite)
    {
        return ResponseEntity.ok(favouriteService.save(favourite));
    }


    @GetMapping("/all")
    public ResponseEntity<List<Favourite>> getAll()
    {
        return ResponseEntity.ok(favouriteService.findAll());
    }

    @GetMapping("/{id}/{login}")
    public ResponseEntity<Favourite> findById(@PathVariable(value = "id") int idService, @PathVariable(value = "login") String login)
    {
        Optional<Favourite> favourite = favouriteService.findById(idService, login);
        if(!favourite.isPresent())
        {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(favourite.get());
    }

    @PutMapping("/{id}/{login}")
    public ResponseEntity<Favourite> update(@PathVariable(value = "id") int idService, @PathVariable(value = "login") String login, @Valid @RequestBody Favourite favourite)
    {
        if(!favouriteService.findById(idService, login).isPresent())
        {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(favouriteService.save(favourite));
    }

    @DeleteMapping("/{id}/{login}")
    public ResponseEntity delete(@PathVariable(value = "id") int idService, @PathVariable(value = "login") String login)
    {

        if(!favouriteService.findById(idService, login).isPresent())
        {
            ResponseEntity.badRequest().build();
        }

        favouriteService.deleteById(idService, login);

        return ResponseEntity.ok().build();
    }

}
