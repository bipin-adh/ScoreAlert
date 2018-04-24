package com.meroteam.scorealert.models;

/**
 * Created by bpn8adh on 24/04/18.
 */

public class Leagues {
    private Links _links;
    private int id;
    private String caption;
    private String league;
    private int year;
    private int currentMatchday;
    private int numberOfMatchdays;
    private int numberOfTeams;
    private int numberOfGames;
    private String lastUpdated;


    protected Leagues() {
    }

    public int getId() {
        return id;
    }

    public String getCaption() {
        return caption;
    }

    public String getLeague() {
        return league;
    }

    public int getYear() {
        return year;
    }

    public int getCurrentMatchday() {
        return currentMatchday;
    }

    public int getNumberOfMatchdays() {
        return numberOfMatchdays;
    }

    public int getNumberOfTeams() {
        return numberOfTeams;
    }

    public int getNumberOfGames() {
        return numberOfGames;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }
}
