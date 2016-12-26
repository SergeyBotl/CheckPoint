package com.example.sergey.checkpoint.dao;

import com.example.sergey.checkpoint.entity.Comanda;
import com.example.sergey.checkpoint.entity.Result;

import java.util.ArrayList;
import java.util.List;

public class ResultDao implements DAO<Result> {

    static List<Result> list = new ArrayList<>();

    public ResultDao() {
        Comanda comanda=new Comanda("Sokol");
           save(new Result(comanda,"2"));
    }

    @Override
    public void save(Result result) {
        result.setId(list.size() + 1);
        list.add(result);

    }

    @Override
    public List<Result> getAll() {
        return list;
    }
}
