package com.example.sergey.checkpoint.dao;

import com.example.sergey.checkpoint.entity.Comanda;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private ComandaDao comandaDao=new ComandaDao();
    private ResultDao resultDao=new ResultDao();


    public List<Comanda> getAllWithAllResult() {
        List<Comanda> list = new ArrayList<>(comandaDao.getAll());
        for (Comanda c : list) {
            c.setSumBall(resultDao.sumBall(c.getNameComanda()));
           
        }
        return list;
    }
}
