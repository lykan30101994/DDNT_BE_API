package com.example.CRUD.repository;

import com.example.CRUD.common.core.Pagination;
import com.example.CRUD.common.core.ResultSet;
import com.example.CRUD.dao.UserDao;
import com.example.CRUD.entity.UserEntity;
import com.example.CRUD.entity.UserEntity_;
import com.example.CRUD.model.request.User.UserRequest;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.seasar.doma.jdbc.SelectOptions;
import org.seasar.doma.jdbc.criteria.Entityql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@AllArgsConstructor
@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
public class UserRepository {
    @Autowired
    private Entityql entityql;
    @Autowired
    private UserDao userDao;

    public ResultSet<UserEntity> getAllUsers(Pagination pagination, UserRequest request) {
        SelectOptions options = SelectOptions.get().count();
        List<UserEntity> list = userDao.selectAll(pagination, request, options);
        var count = options.getCount();

        return new ResultSet<>(list, count);

    }

    /**
     * Create new user
     *
     * @param userEntity entity user
     */
    public void create(UserEntity userEntity) {
        var entity = new UserEntity_();

        entityql.insert(entity, userEntity).execute().getEntity();
    }

    /**
     *
     * @param id id of user
     * @param userEntity entity user
     * @return entity user
     */
    public UserEntity update(Integer id, UserEntity userEntity) {
        if (!isExist(id)) {
            return null;
        }

        var entity = new UserEntity_();
        var result = entityql.update(entity, userEntity.withId(id)).execute().getCount();

        if (result != 1) {
            return  null;
        }

        return getById(id);
    }

    /**
     * Get by id user
     *
     * @param id id of user
     * @return entity user
     */
    public UserEntity getById (Integer id) {
        var entity = new UserEntity_();

        return entityql.from(entity).where(c -> c.eq(entity.id, id)).fetchOne();
    }

    public void delete (Integer id) {
        if (!isExist(id)) {
            return;
        }
        var entity = new UserEntity_();
        var entityDelete = getById(id);

        entityql.delete(entity, entityDelete).execute();
    }

    /**
     * Check user exist in list users
     *
     * @param id id of user
     * @return boolean
     */
    private boolean isExist(Integer id) {
        var entity = new UserEntity_();
        var entityExists = entityql.from(entity).where(c -> c.eq(entity.id, id)).fetchOne();
        return entityExists != null;
    }
}
