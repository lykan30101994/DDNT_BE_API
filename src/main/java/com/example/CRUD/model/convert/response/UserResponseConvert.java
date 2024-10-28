package com.example.CRUD.model.convert.response;

import com.example.CRUD.entity.UserEntity;
import com.example.CRUD.model.response.User.UserResponse;
import com.example.CRUD.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class UserResponseConvert {
    public static UserResponse convertDataResponseUser(UserEntity entity) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        return modelMapper.map(entity, UserResponse.class);
    }
}
