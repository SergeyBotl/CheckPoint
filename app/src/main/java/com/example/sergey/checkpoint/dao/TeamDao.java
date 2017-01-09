package com.example.sergey.checkpoint.dao;

import android.util.Log;

import com.example.sergey.checkpoint.entity.Team;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TeamDao implements DAO<Team> {

    static Set<Team> set = new HashSet<>();


    public TeamDao() {
        save(new Team("Sokol"));
        save(new Team("Dinamo"));
    }



    @Override
    public void save(Team comanda) {
        comanda.setId(set.size() + 1);
        set.add(comanda);
    }

    @Override
    public List<Team> getAll() {
        return new ArrayList<>(set);
    }

    public List<String> getColumnName() {
        Set<String> listName = new HashSet<>();
        for (Team c : getAll()) {
            listName.add(c.getName());
        }
        return new ArrayList<>(listName);
    }

    public Team findByName(String s) {
        for (Team c : getAll()) {
            if (c.getName().equals(s)) {
                Log.d("Tag", "s: " + s + " !!!!comanda  " + c);
                return c;
            }
        }
        return null;
    }
}
