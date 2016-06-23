package com.example.rachelhutchison.guessinggame.model;

import java.io.Serializable;

public class PlayerImage implements Serializable {
    private DefaultImage defaultImage;

    public DefaultImage getDefaultImage() {
        return defaultImage;
    }

    public void setDefaultImage(DefaultImage defaultImage) {
        this.defaultImage = defaultImage;
    }
}
