package com.example.sergey.checkpoint.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Result implements Serializable {
    private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy");
    private long id;
    private Team team;
    private int ballInt;
    private String date;


    public Result(Date date, Team team, int ball) {
        this.date = sdf.format(date);
        this.team = team;
        this.ballInt = ball;
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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public int getBallInt() {
        return ballInt;
    }

     @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Result result = (Result) o;

        if (id != result.id) return false;
        if (ballInt != result.ballInt) return false;
        if (team != null ? !team.equals(result.team) : result.team != null) return false;
        return date != null ? date.equals(result.date) : result.date == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (team != null ? team.hashCode() : 0);
        result = 31 * result + ballInt;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", nameComanda=" + team +
                ", ball=" + ballInt;
    }
}
