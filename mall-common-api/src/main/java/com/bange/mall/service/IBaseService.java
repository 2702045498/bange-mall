package com.bange.mall.service;


import java.util.List;

public interface  IBaseService<T> {

    public  T query(T t);
    public  List<T> queryList(T t);
    public  int save(T t);
    public  int edit(T t);
    public  int remove(T t);
}
