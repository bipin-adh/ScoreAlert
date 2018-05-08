package com.meroteam.scorealert.models;

import java.util.List;

/**
 * Created by bpn8adh on 08/05/18.
 */

public class LeagueTable {
    private String leagueCaption;
    private String matchday;
    private List<Standing> standing;

    protected LeagueTable() {

    }

    public String getLeagueCaption() {
        return leagueCaption;
    }

    public String getMatchday() {
        return matchday;
    }

    public List<Standing> getStanding() {
        return standing;
    }
}
