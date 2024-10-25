package com.example.CRUD.service;

import com.example.CRUD.entity.UserEntity;
import com.example.CRUD.model.convert.UserEntityConvert;
import com.example.CRUD.model.request.User.UserRequest;
import com.example.CRUD.model.response.ListResponse;
import com.example.CRUD.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public ListResponse<UserEntity> getAllUsers() {
        var result = userRepository.getAllUsers();

        return ListResponse.<UserEntity>builder().data(result.getData()).build();
    }

    public void createUsers(UserRequest user) {
        var userEntity = UserEntityConvert.convertCreateUserRequestToEntity(user);

        userRepository.create(userEntity);
    }

}
