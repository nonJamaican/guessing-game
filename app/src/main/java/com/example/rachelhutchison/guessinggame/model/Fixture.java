package com.example.rachelhutchison.guessinggame.model;

public class Fixture {
    private FixtureTeam awayTeam;
    private FixtureTeam homeTeam;
    private String id;
    private String sport;
    private String startDate;
    private Object status;

    public FixtureTeam getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(FixtureTeam awayTeam) {
        this.awayTeam = awayTeam;
    }

    public void setHomeTeam(FixtureTeam homeTeam) {
        this.homeTeam = homeTeam;
    }

    public FixtureTeam getHomeTeam() {
        return homeTeam;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }
}
