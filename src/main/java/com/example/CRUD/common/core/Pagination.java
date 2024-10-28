package com.example.CRUD.common.core;

public class Pagination {
    private  int page = 0;
    private  int limit = 10;

    public Pagination(int pageReal, int limitReal) {
        this.page = pageReal;
        this.limit = limitReal;
    }

    public static Pagination of (final Integer page, Integer limit) {
        var pageReal = page ==  null ? 0 : page - 1 ;
        var limitReal = limit == null ? 10 : limit;

        return new Pagination(pageReal, limitReal);
    }


    public int getPage() {
        return page;
    }

    public int getLimit() {
        return limit;
    }

    @Override
    public String toString() {

        return "Pagination{page: " + page + " limit: " + limit + "}";
    }
}
