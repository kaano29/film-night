package de.volkswagen.filmnightbackend.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{username}")
    public Optional<UserEntity> getUser(@PathVariable String username) {
        return userService.getUser(username);
    }

    @GetMapping
    public Optional<List<String>> getUsersById(@RequestBody Long[] userIdList) {
        return userService.getUsersById(userIdList);
    }

    @PostMapping
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.createUser(user));
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void invalidCarException(InvalidUserException e) {
    }

    @PutMapping
    public UserEntity updateUser(@RequestBody UserEntity user) {
        return userService.updateUser(user);
    }




}
