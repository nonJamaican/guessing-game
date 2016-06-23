package com.example.rachelhutchison.guessinggame.model;

import java.io.Serializable;

public class News implements Serializable {

    private String latest;

    public String getLatest() {
        return latest;
    }

    public void setLatest(String latest) {
        this.latest = latest;
    }
}
