package com.example.sergey.checkpoint.dao;

import java.util.List;

public interface DAO <T>{

   void save(T t);

    List<T>getAll();
}
