package com.example.sergey.checkpoint.api;

import com.example.sergey.checkpoint.dao.TeamDao;
import com.example.sergey.checkpoint.dao.ResultDao;
import com.example.sergey.checkpoint.entity.Result;
import com.example.sergey.checkpoint.entity.Team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Controller {
    private TeamDao teamDao = new TeamDao();
    private ResultDao resultDao = new ResultDao();

    public List<Team> getAllWithAllResult() {
        List<Team> list = new ArrayList<>(teamDao.getAll());
        for (Team c : list) {
            c.setSumBall(resultDao.sumBall(c.getName()));
        }
        return list;
    }

    public List<Result> getResultList() {
        Collections.sort(resultDao.getAll(), new Comparator<Result>() {
            @Override
            public int compare(Result result, Result t1) {
                return result.getBallInt() - t1.getBallInt();
            }
        });
        return null;
    }

    public Team findByName(String s) {
        return teamDao.findByName(s);
    }

    public List<Result> allResultsForTeam(String s) {
        return resultDao.allResultsForComanda(s);
    }

    public List<String> getNameTeamList() {
        List<String> list = teamDao.getColumnName();
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return s.compareTo(t1);
            }
        });
        return list;
    }

    public void saveResult(Result result) {
        resultDao.save(result);
    }
}
