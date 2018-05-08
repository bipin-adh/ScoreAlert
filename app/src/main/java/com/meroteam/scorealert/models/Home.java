package com.meroteam.scorealert.models;

/**
 * Created by bpn8adh on 08/05/18.
 */

public class Home {
    private long goals;
    private long goalsAgainst;
    private long wins;
    private long draws;
    private long losses;

    protected Home() {

    }

    public long getGoals() {
        return goals;
    }

    public long getGoalsAgainst() {
        return goalsAgainst;
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
}
