package com.example.sergey.checkpoint.entity;

public class Comanda {
    private long id;
    private String nameComanda;

    public Comanda() {
    }

    public Comanda(String nameComanda) {
        this.nameComanda = nameComanda;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameComanda() {
        return nameComanda;
    }

    public void setNameComanda(String nameComanda) {
        this.nameComanda = nameComanda;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comanda comanda = (Comanda) o;

        return nameComanda != null ? nameComanda.equals(comanda.nameComanda) : comanda.nameComanda == null;

    }

    @Override
    public int hashCode() {
        return nameComanda != null ? nameComanda.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Comanda{\n" +
                "id=" + id +
                ", \nnameComanda='" + nameComanda + '\'' +
                '}';
    }
}
