package com.example.sergey.checkpoint.entity;

import java.text.SimpleDateFormat;

public class Match {
    private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy");
    private long id;
    private String name;
    private Team team1;
    private Team team2;
    private long date;
}
