package com.example.CRUD.model.request.User;

import com.example.CRUD.common.validation.annotation.ValidEmail;
import com.example.CRUD.common.validation.annotation.ValidRequired;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@AllArgsConstructor
@Validated
public class UserRequest {

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    @ValidRequired
    @ValidEmail
    private String email;
}
