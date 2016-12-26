package com.example.sergey.checkpoint.dao;

import com.example.sergey.checkpoint.entity.Comanda;
import com.example.sergey.checkpoint.entity.Result;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ResultDao implements DAO<Result> {
    ComandaDao comandaDao = new ComandaDao();
    static Set<Result> set = new HashSet<>();
    static List<Result> list = new ArrayList<>(set);

    public ResultDao() {
        Comanda comanda = new Comanda("Sokol");
        save(new Result(comanda, "2"));
    }

    @Override
    public void save(Result result) {
        result.setId(list.size() + 1);
        set.add(result);

    }

    @Override
    public List<Result> getAll() {
        return list;
    }
}
