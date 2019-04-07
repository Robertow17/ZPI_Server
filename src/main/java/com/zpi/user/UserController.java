package com.zpi.user;

import com.zpi.category.Category;
import com.zpi.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/users")
public class UserController
{

    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity create(@Valid @RequestBody User user)
    {
        return ResponseEntity.ok(userService.save(user));
    }


    @GetMapping("/all")
    public ResponseEntity<List<User>> getAll()
    {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{login}")
    public ResponseEntity<User> findById(@PathVariable(value = "login") String login)
    {
        Optional<User> user = userService.findById(login);
        if(!user.isPresent())
        {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(user.get());
    }

    @PutMapping("/{login}")
    public ResponseEntity<User> update(@PathVariable(value = "login") String login, @Valid @RequestBody User user)
    {
        if(!userService.findById(login).isPresent())
        {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(userService.save(user));
    }

    @DeleteMapping("/{login}")
    public ResponseEntity delete(@PathVariable(value = "login") String login)
    {
        if(!userService.findById(login).isPresent())
        {
            ResponseEntity.badRequest().build();
        }

        userService.deleteById(login);

        return ResponseEntity.ok().build();
    }

}
