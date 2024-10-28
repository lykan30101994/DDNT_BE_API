package com.example.CRUD.service;

import com.example.CRUD.common.core.Pagination;
import com.example.CRUD.entity.UserEntity;
import com.example.CRUD.model.convert.request.UserEntityConvert;
import com.example.CRUD.model.convert.response.UserResponseConvert;
import com.example.CRUD.model.request.User.UserRequest;
import com.example.CRUD.model.response.ListResponse;
import com.example.CRUD.model.response.User.UserResponse;
import com.example.CRUD.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public ListResponse<UserResponse> getAllUsers(Pagination pagination, UserRequest request) {
        var result = userRepository.getAllUsers(pagination, request);
        var response = result.getData().stream().map(UserResponseConvert::convertDataResponseUser).toList();

        return ListResponse.<UserResponse>builder().data(response).count(result.getCount()).build();
    }

    public void createUsers(UserRequest user) {
        var userEntity = UserEntityConvert.convertUserRequestToEntity(user);

        userRepository.create(userEntity);
    }

    public UserEntity update(Integer id, UserRequest userRequest) {
        var entity = UserEntityConvert.convertUserRequestToEntity(userRequest);

        return userRepository.update(id, entity);
    }

    public UserEntity getById(Integer id) {
        return userRepository.getById(id);
    }

    public void delete(Integer id) {
        userRepository.delete(id);
    }
}
