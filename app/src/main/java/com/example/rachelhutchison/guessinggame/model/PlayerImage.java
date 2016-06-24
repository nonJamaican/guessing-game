package com.example.rachelhutchison.guessinggame.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PlayerImage implements Serializable {
    @SerializedName("default")
    private DefaultImage defaultImage;

    public DefaultImage getDefaultImage() {
        return defaultImage;
    }

    public void setDefaultImage(DefaultImage defaultImage) {
        this.defaultImage = defaultImage;
    }
}
