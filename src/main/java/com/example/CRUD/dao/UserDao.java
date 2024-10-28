package com.example.CRUD.dao;

import com.example.CRUD.common.core.Pagination;
import com.example.CRUD.entity.UserEntity;
import com.example.CRUD.model.request.User.UserRequest;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.SelectOptions;

import java.util.List;

@Dao
@ConfigAutowireable
public interface UserDao {

    @Select
    List<UserEntity> selectAll(Pagination pagination, UserRequest request, SelectOptions options);
}
