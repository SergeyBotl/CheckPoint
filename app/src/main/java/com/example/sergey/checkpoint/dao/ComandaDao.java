package com.example.sergey.checkpoint.dao;

import com.example.sergey.checkpoint.entity.Comanda;

import java.util.ArrayList;
import java.util.List;

public class ComandaDao implements DAO<Comanda> {

   static List<Comanda>list=new ArrayList<>();

    public ComandaDao() {
       save(new Comanda("Dinamo"));
    }

    @Override
    public void save(Comanda comanda) {
        comanda.setId(list.size()+1);
        list.add(comanda);
    }

    @Override
    public List<Comanda> getAll() {
        return list;
    }
}
