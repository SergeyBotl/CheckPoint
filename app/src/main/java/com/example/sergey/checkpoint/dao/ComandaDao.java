package com.example.sergey.checkpoint.dao;

import android.util.Log;

import com.example.sergey.checkpoint.entity.Comanda;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ComandaDao implements DAO<Comanda> {

    static Set<Comanda> set = new HashSet<>();


    public ComandaDao() {
        save(new Comanda("Sokol"));
        save(new Comanda("Dinamo"));
    }



    @Override
    public void save(Comanda comanda) {
        comanda.setId(set.size() + 1);
        set.add(comanda);
    }

    @Override
    public List<Comanda> getAll() {
        return new ArrayList<>(set);
    }

    public List<String> getColumnName() {
        Set<String> listName = new HashSet<>();
        for (Comanda c : getAll()) {
            listName.add(c.getNameComanda());
        }
        return new ArrayList<>(listName);
    }

    public Comanda findByName(String s) {
        for (Comanda c : getAll()) {
            if (c.getNameComanda().equals(s)) {
                Log.d("Tag", "s: " + s + " !!!!comanda  " + c);
                return c;
            }
        }
        return null;
    }
}
