package com.meroteam.scorealert.models;

/**
 * Created by bpn8adh on 08/05/18.
 */

public class Standing {
    private long position;
    private String teamName;
    private String crestURI;
    private long playedGames;
    private long points;
    private long goals;
    private long goalsAgainst;
    private long goalDifference;
    private long wins;
    private long draws;
    private long losses;

    private Home home;
    private Away away;

    protected Standing() {

    }

    public long getPosition() {
        return position;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getCrestURI() {
        return crestURI;
    }

    public long getPlayedGames() {
        return playedGames;
    }

    public long getPoints() {
        return points;
    }

    public long getGoals() {
        return goals;
    }

    public long getGoalsAgainst() {
        return goalsAgainst;
    }

    public long getGoalDifference() {
        return goalDifference;
    }

    public long getWins() {
        return wins;
    }

    public long getDraws() {
        return draws;
    }

    public long getLosses() {
        return losses;
    }

    public Home getHome() {
        return home;
    }

    public Away getAway() {
        return away;
    }
}