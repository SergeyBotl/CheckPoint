package com.example.sergey.checkpoint.entity;


import android.text.Editable;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Result {
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy");
    private long id;
    private Comanda nameComanda;
    private int ballInt;
    private String ball;
    private String date;


    public Result(Date date, Comanda nameComanda, String ball) {

        this.date =sdf.format(date) ;
        this.nameComanda = nameComanda;
        this.ball = ball;
        this.ballInt = Integer.parseInt(ball);

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public int getBallInt() {
        return ballInt;
    }

    public void setBallInt(int ballInt) {
        this.ballInt = ballInt;
    }

    public String getBall() {
        return ball;
    }

    public void setBall(String ball) {
        this.ball = ball;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Result result = (Result) o;

        if (nameComanda != null ? !nameComanda.equals(result.nameComanda) : result.nameComanda != null)
            return false;
        return ball != null ? ball.equals(result.ball) : result.ball == null;

    }

    @Override
    public int hashCode() {
        int result = nameComanda != null ? nameComanda.hashCode() : 0;
        result = 31 * result + (ball != null ? ball.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", nameComanda=" + nameComanda +
                ", ball=" + ball;
    }
}
