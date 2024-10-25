package com.example.CRUD.common.core;

import java.util.List;

public class ResultSet<T> {
    private final List<T> mEntity;

    public ResultSet(final List<T> entities) {
        this.mEntity = entities;
    }

    public List<T> getData() {
        return mEntity;
    }

}
