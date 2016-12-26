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

    public List<String> getColumnName(){
        List<String>listName=new ArrayList<>();
        for (Comanda c:list){
            listName.add(c.getNameComanda());
        }
        return listName;
    }

    public Comanda findByName(String s){
        for (Comanda c:list){
            if (c.getNameComanda().equals(s)){
                return c;
            }
        }
        return null;
    }
}
