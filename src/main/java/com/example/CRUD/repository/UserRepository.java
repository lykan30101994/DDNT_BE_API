package com.example.CRUD.repository;

import com.example.CRUD.common.core.ResultSet;
import com.example.CRUD.dao.UserDao;
import com.example.CRUD.entity.UserEntity;
import com.example.CRUD.entity.UserEntity_;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.seasar.doma.jdbc.criteria.Entityql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@AllArgsConstructor
@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
public class UserRepository {
    private Entityql entityql;
    @Autowired
    private UserDao userDao;

    public ResultSet<UserEntity> getAllUsers() {
        List<UserEntity> list = userDao.selectAll();

        return new ResultSet<>(list);
    }

    public void create(UserEntity userEntity) {
        var entity = new UserEntity_();

        entityql.insert(entity, userEntity).execute().getEntity();
    }
}
