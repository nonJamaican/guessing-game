package com.example.rachelhutchison.guessinggame.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class FixtureTeam implements Serializable {

    private Object score;
    @SerializedName("team")
    private PlayerTeam playerTeam;

    public Object getScore() {
        return score;
    }

    public void setScore(Object score) {
        this.score = score;
    }

    public PlayerTeam getPlayerTeam() {
        return playerTeam;
    }

    public void setPlayerTeam(PlayerTeam playerTeam) {
        this.playerTeam = playerTeam;
    }
}
