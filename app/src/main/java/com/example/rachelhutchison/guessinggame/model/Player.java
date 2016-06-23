package com.example.rachelhutchison.guessinggame.model;

import java.io.Serializable;

public class Player implements Serializable {

    private String firstName;
    private PlayerFixture playerFixture;
    private double fppg;
    private String id;
    private PlayerImage images;
    private boolean injured;
    private String injuryDetails;
    private String injuryStatus;
    private int played;
    private String playerCardUrl;
    private String position;
    private boolean removed;
    private int salary;
    private Object startingOrder;
    private PlayerTeam playerTeam;
    private String lastName;
    private News news;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public PlayerFixture getPlayerFixture() {
        return playerFixture;
    }

    public void setPlayerFixture(PlayerFixture playerFixture) {
        this.playerFixture = playerFixture;
    }

    public double getFppg() {
        return fppg;
    }

    public void setFppg(double fppg) {
        this.fppg = fppg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PlayerImage getImages() {
        return images;
    }

    public void setImages(PlayerImage images) {
        this.images = images;
    }

    public boolean getInjured() {
        return injured;
    }

    public void setInjured(boolean injured) {
        this.injured = injured;
    }

    public String getInjuryDetails() {
        return injuryDetails;
    }

    public void setInjuryDetails(String injuryDetails) {
        this.injuryDetails = injuryDetails;
    }

    public String getInjuryStatus() {
        return injuryStatus;
    }

    public void setInjuryStatus(String injuryStatus) {
        this.injuryStatus = injuryStatus;
    }

    public int getPlayed() {
        return played;
    }

    public void setPlayed(int played) {
        this.played = played;
    }

    public String getPlayerCardUrl() {
        return playerCardUrl;
    }

    public void setPlayerCardUrl(String playerCardUrl) {
        this.playerCardUrl = playerCardUrl;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean getRemoved() {
        return removed;
    }

    public void setRemoved(boolean removed) {
        this.removed = removed;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Object getStartingOrder() {
        return startingOrder;
    }

    public void setStartingOrder(Object startingOrder) {
        this.startingOrder = startingOrder;
    }

    public PlayerTeam getPlayerTeam() {
        return playerTeam;
    }

    public void setPlayerTeam(PlayerTeam playerTeam) {
        this.playerTeam = playerTeam;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }
}
