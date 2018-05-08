package com.meroteam.scorealert.models;

/**
 * Created by bpn8adh on 24/04/18.
 * href contains api url for respective class names.
 */

public class Links {

    private SelfUrl self;
    private TeamsUrl teams;
    private FixturesUrl fixtures;
    private LeagueTableUrl leagueTable;

    protected Links() {

    }

    public SelfUrl getSelf() {
        return self;
    }

    public TeamsUrl getTeams() {
        return teams;
    }

    public FixturesUrl getFixtures() {
        return fixtures;
    }

    public LeagueTableUrl getLeagueTable() {
        return leagueTable;
    }

    public class SelfUrl {
        public SelfUrl() {

        }

        private String href;

        public String getHref() {
            return href;
        }
    }

    public class TeamsUrl {
        public TeamsUrl() {

        }

        private String href;

        public String getHref() {
            return href;
        }
    }

    public class FixturesUrl {

        public FixturesUrl() {

        }

        private String href;

        public String getHref() {
            return href;
        }
    }

    public class LeagueTableUrl {
        public LeagueTableUrl() {

        }

        private String href;

        public String getHref() {
            return href;
        }
    }
}