package com.example.rachelhutchison.guessinggame.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Fixture implements Serializable {
    @SerializedName("away_team")
    private FixtureTeam awayTeam;
    @SerializedName("home_team")
    private FixtureTeam homeTeam;
    private String id;
    private String sport;
    @SerializedName("start_date")
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
