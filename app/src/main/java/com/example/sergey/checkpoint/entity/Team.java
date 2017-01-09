package com.example.sergey.checkpoint.entity;

public class Team {
    private long id;
    private String name;
    private int sumBall;

    public Team() {
    }

    public Team(String nameTeam) {
        this.name = nameTeam;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSumBall() {
        return sumBall;
    }

    public void setSumBall(int sumBall) {
        this.sumBall = sumBall;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team comanda = (Team) o;

        return name != null ? name.equals(comanda.name) : comanda.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", nameTeam='" + name + '\'' +
                '}';
    }
}
