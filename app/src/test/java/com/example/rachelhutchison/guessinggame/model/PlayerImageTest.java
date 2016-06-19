package com.example.rachelhutchison.guessinggame.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PlayerImageTest {

    private PlayerImage image;

    @Before
    public void setUp() {
        image = new PlayerImage();
    }

    @Test
    public void hasAttributeDefaultImage() {
        assertNull(image.getDefaultImage());
    }

    @Test
    public void defaultImageWillReturnAsSet() {
        DefaultImage defaultImage = new DefaultImage();
        image.setDefaultImage(defaultImage);
        assertEquals(defaultImage, image.getDefaultImage());
    }

}