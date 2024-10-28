package com.example.CRUD.common.core;

import lombok.Getter;

import java.util.List;

public class ResultSet<T> {
    private final List<T> mEntity;
    @Getter
    private final long count;

    public ResultSet(final List<T> entities, long count) {
        this.mEntity = entities;
        this.count = count;
    }

    public List<T> getData() {
        return mEntity;
    }

}
