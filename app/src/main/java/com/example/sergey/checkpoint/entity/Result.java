package com.example.sergey.checkpoint.entity;

import android.text.Editable;

public class Result {

    private long id;
    private Comanda nameComanda;
    private int ballInt;
    private String ball;


    public Result(Comanda nameComanda, String ball) {
        this.nameComanda = nameComanda;
        this.ball = ball;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Comanda getNameComanda() {
        return nameComanda;
    }

    public void setNameComanda(Comanda nameComanda) {
        this.nameComanda = nameComanda;
    }

    public int getBall() {
        return ballInt;
    }

    public void setBall(int ball) {
        this.ballInt = ball;
    }

    public int getBallInt() {
        return ballInt;
    }

    public void setBallInt(int ballInt) {
        this.ballInt = ballInt;
    }

    public void setBall(String ball) {
        this.ball = ball;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", nameComanda=" + nameComanda +
                ", ball=" + ball ;
    }
}
