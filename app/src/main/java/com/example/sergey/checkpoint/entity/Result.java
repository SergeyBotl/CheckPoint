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
        this.ballInt = Integer.parseInt(ball);

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
        return  "id=" + id +
                ", nameComanda=" + nameComanda +
                ", ball=" + ball ;
    }
}
