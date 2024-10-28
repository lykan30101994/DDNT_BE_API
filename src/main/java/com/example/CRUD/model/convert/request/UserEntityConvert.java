package com.example.CRUD.model.convert.request;

import com.example.CRUD.entity.UserEntity;
import com.example.CRUD.model.request.User.UserRequest;
import org.modelmapper.ModelMapper;

public class UserEntityConvert {
    public static UserEntity convertUserRequestToEntity(UserRequest userRequest){
        ModelMapper mapper = new ModelMapper();

        return mapper.map(userRequest, UserEntity.class);
    }

}
