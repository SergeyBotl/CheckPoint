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
    static List<Result> list;

    public ResultDao() {
        //Comanda comanda = new Comanda("Sokol");
        Comanda comanda = comandaDao.findByName("Sokol");
        save(new Result(comanda, "2"));
    }

    @Override
    public void save(Result result) {
        result.setId(set.size() + 1);
        set.add(result);

    }

    @Override
    public List<Result> getAll() {
        return list = new ArrayList<>(set);
    }

    public List<Result> allResultsForComanda(String s) {
        List<Result> listResult = new ArrayList<>();
        for (Result r : getAll()) {
            if (r.getNameComanda().getNameComanda().equals(s)) {
                listResult.add(r);
            }
        }
        return listResult;
    }
}
