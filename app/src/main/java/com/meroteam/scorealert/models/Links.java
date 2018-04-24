package com.meroteam.scorealert.models;

/**
 * Created by bpn8adh on 24/04/18.
 */

public class Links {

    private Self self;
    private Teams teams;
    private Fixtures fixtures;
    private LeagueTable leagueTable;

    public Self getSelf() {
        return self;
    }

    public Teams getTeams() {
        return teams;
    }

    public Fixtures getFixtures() {
        return fixtures;
    }

    public LeagueTable getLeagueTable() {
        return leagueTable;
    }

    private class Self {
        private String href;

        public String getHref() {
            return href;
        }
    }

    private class Teams {
        private String href;

        public String getHref() {
            return href;
        }
    }

    private class Fixtures {
        private String href;

        public String getHref() {
            return href;
        }
    }

    private class LeagueTable {
        private String href;

        public String getHref() {
            return href;
        }
    }
}