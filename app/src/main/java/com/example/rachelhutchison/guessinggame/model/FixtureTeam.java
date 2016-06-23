package com.example.rachelhutchison.guessinggame.model;

import java.io.Serializable;

public class FixtureTeam implements Serializable {

    private Object score;
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
