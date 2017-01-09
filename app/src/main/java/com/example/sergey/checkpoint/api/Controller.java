package com.example.sergey.checkpoint.api;

import com.example.sergey.checkpoint.dao.ComandaDao;
import com.example.sergey.checkpoint.dao.ResultDao;
import com.example.sergey.checkpoint.entity.Team;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private ComandaDao comandaDao=new ComandaDao();
    private ResultDao resultDao=new ResultDao();


    public List<Team> getAllWithAllResult() {
        List<Team> list = new ArrayList<>(comandaDao.getAll());
        for (Team c : list) {
            c.setSumBall(resultDao.sumBall(c.getName()));

        }
        return list;
    }
}
