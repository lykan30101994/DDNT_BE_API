package com.example.CRUD.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse {
    @JsonProperty("number_of_updates")
    public LocalDateTime createAt;

    @JsonProperty("deletedAt")
    public  LocalDateTime deletedAt;

    @JsonProperty("numberOfUpdates")
    public Integer numberOfUpdates;
}
