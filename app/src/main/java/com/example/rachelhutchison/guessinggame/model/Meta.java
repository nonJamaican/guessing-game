package com.example.rachelhutchison.guessinggame.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Meta implements Serializable {

    @SerializedName("_primary_document")
    private String primaryDocument;
    private Players players;

    public String getPrimaryDocument() {
        return primaryDocument;
    }

    public void setPrimaryDocument(String primaryDocument) {
        this.primaryDocument = primaryDocument;
    }

    public Players getPlayers() {
        return players;
    }

    public void setPlayers(Players players) {
        this.players = players;
    }
}
