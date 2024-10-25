package com.example.CRUD.dao;

import com.example.CRUD.entity.UserEntity;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

@Dao
@ConfigAutowireable
public interface UserDao {

    @Select
    List<UserEntity> selectAll();
}
