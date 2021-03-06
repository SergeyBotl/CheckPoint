package com.example.sergey.checkpoint.dao;

import com.example.sergey.checkpoint.entity.Result;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ResultDao implements DAO<Result> {
    private static Set<Result> set = new HashSet<>();

    public ResultDao() {
      /*  ComandaDao comandaDao = new ComandaDao();
        Comanda comanda = comandaDao.findByName("Sokol");
        Comanda dinamo = comandaDao.findByName("Dinamo");
        save(new Result(new Date(),comanda, "1"));
        save(new Result(new Date(),dinamo, "3"));*/
    }

    @Override
    public void save(Result result) {
        result.setId(set.size() + 1);
        set.add(result);

    }

    @Override
    public List<Result> getAll() {
        return new ArrayList<>(set);
    }

    public List<Result> allResultsForComanda(String s) {
        List<Result> listResult = new ArrayList<>();
        for (Result r : getAll()) {
            if (r.getTeam().getName().equals(s)) {
                listResult.add(r);
            }
        }
        return listResult;
    }
    public int sumBall(String nameComand){
        int sum=0;
        for (Result r:getAll()){
            if (r.getTeam().getName().equals(nameComand)){
                sum+=r.getBallInt();
            }
        }
        return sum;
    }
}
