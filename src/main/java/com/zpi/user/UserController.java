package com.zpi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<UserDTO> create(@Valid @RequestBody UserDTO userDTO)
    {
        userService.save(UserMapper.INSTANCE.toUser(userDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
    }


    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getAll()
    {
        return ResponseEntity.ok(UserMapper.INSTANCE.toUserDTOs(userService.findAll()));
    }

    @GetMapping("/{login}")
    public ResponseEntity<UserDTO> findById(@PathVariable(value = "login") String login)
    {
        Optional<User> user = userService.findById(login);

        if(!user.isPresent())
        {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(UserMapper.INSTANCE.toUserDTO(user.get()));
    }

    @PutMapping("/{login}")
    public ResponseEntity<UserDTO> update(@PathVariable(value = "login") String login, @Valid @RequestBody UserDTO userDTO)
    {
        User user = UserMapper.INSTANCE.toUser(userDTO);
        user.setLogin(login);
        userService.save(user);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userDTO);
    }

    @DeleteMapping("/{login}")
    public ResponseEntity delete(@PathVariable(value = "login") String login)
    {
        userService.deleteById(login);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
