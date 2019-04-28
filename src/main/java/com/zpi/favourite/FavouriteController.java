package com.zpi.favourite;

import com.zpi.category.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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


    @PostMapping(("/add"))
    public ResponseEntity<FavouriteDTO> create(@Valid @RequestBody FavouriteDTO favouriteDTO)
    {
        favouriteService.save(FavouriteMapper.INSTANCE.toFavourite(favouriteDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(favouriteDTO);
    }


    @GetMapping("/all")
    public ResponseEntity<List<FavouriteDTO>> getAll()
    {
        return ResponseEntity.ok(FavouriteMapper.INSTANCE.toFavouriteDTOs(favouriteService.findAll()));
    }

    @GetMapping("/{id}/{login}")
    public ResponseEntity<FavouriteDTO> findById(@PathVariable(value = "id") int idService, @PathVariable(value = "login") String login)
    {
        Optional<Favourite> favourite = favouriteService.findById(idService, login);

        if(!favourite.isPresent())
        {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(FavouriteMapper.INSTANCE.toFavouriteDTO(favourite.get()));
    }

    @PutMapping("/{id}/{login}")
    public ResponseEntity<FavouriteDTO> update(@PathVariable(value = "id") int idService, @PathVariable(value = "login") String login, @Valid @RequestBody FavouriteDTO favouriteDTO)
    {
        Favourite favourite = FavouriteMapper.INSTANCE.toFavourite(favouriteDTO);
        favourite.setId(new FavouritePK(idService, login));
        favouriteService.save(favourite);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(favouriteDTO);
    }

    @DeleteMapping("/{id}/{login}")
    public ResponseEntity delete(@PathVariable(value = "id") int idService, @PathVariable(value = "login") String login)
    {
        favouriteService.deleteById(idService, login);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
