package com.midwesttape.project.challengeapplication.rest;

import com.midwesttape.project.challengeapplication.model.User;
import com.midwesttape.project.challengeapplication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/v1/users/{userId}")
    public User user(@PathVariable final Long userId) {
        return userService.user(userId);
    }

    @PostMapping("v1/user")
    public ResponseEntity update(@RequestBody User user) {
        return  userService.update(user) > 0 ? new ResponseEntity( HttpStatus.ACCEPTED) : new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
