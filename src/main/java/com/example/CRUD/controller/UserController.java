package com.example.CRUD.controller;

import com.example.CRUD.common.core.Pagination;
import com.example.CRUD.entity.UserEntity;
import com.example.CRUD.model.request.User.UserRequest;
import com.example.CRUD.model.response.ListResponse;
import com.example.CRUD.model.response.User.UserResponse;
import com.example.CRUD.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/users")
@Validated
@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
public class UserController {
    @Autowired
    private final UserService userService;

    /**
     *  Get all users
     *
     * @param request request param
     * @return UserResponse
     */
    @GetMapping
    public ResponseEntity<ListResponse<UserResponse>> getAllUsers(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit,
            @ModelAttribute UserRequest request) {

        var pagination = Pagination.of(page, limit);
        var result = userService.getAllUsers(pagination, request);

        return ResponseEntity.ok(result);
    }

    /**
     *  Create new user
     *
     * @param userRequest request body
     * @return UserResponse
     */
    @PostMapping
    public ResponseEntity<Void> createUsers(@RequestBody @Valid UserRequest userRequest) {
         userService.createUsers(userRequest);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     *  Update info user
     *
     * @param id id of user
     * @param userRequest request body
     * @return user get by id
     */
    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> updateUser (
           @Valid @PathVariable(value = "id", required = true) Integer id,
           @RequestBody(required = true) @Valid UserRequest userRequest
    ) {
        var result = userService.update(id, userRequest);

        return ResponseEntity.ok(result);
    }

    /**
     * Get by id user
     *
     * @param id id of user
     * @return user response
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getByIdUser (@Valid @PathVariable(value = "id", required = true) Integer id) {
        var result = userService.getById(id);

        return ResponseEntity.ok(result);
    }

    /**
     * Delete user
     *
     * @param id of user
     * @return no content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@Valid @PathVariable(value = "id", required = true) Integer id) {
        userService.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

}
