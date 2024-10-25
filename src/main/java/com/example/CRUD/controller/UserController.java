package com.example.CRUD.controller;

import com.example.CRUD.entity.UserEntity;
import com.example.CRUD.model.request.User.UserRequest;
import com.example.CRUD.model.response.ListResponse;
import com.example.CRUD.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
public class UserController {
    @Autowired
    private final UserService userService;

    @GetMapping
    public ResponseEntity<ListResponse<UserEntity>> getAllUsers() {
        var result = userService.getAllUsers();

        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<Void> createUsers(@RequestBody UserRequest userRequest) {
         userService.createUsers(userRequest);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
