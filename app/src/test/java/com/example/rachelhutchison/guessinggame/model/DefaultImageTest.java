package com.example.rachelhutchison.guessinggame.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class DefaultImageTest {

    private DefaultImage defaultImage;

    @Before
    public void setUp() {
        defaultImage = new DefaultImage();
    }

    @Test
    public void shouldHaveHeight() {
        assertTrue(0 == defaultImage.getHeight());
    }

    @Test
    public void shouldReturnHeightAsSet() {
        defaultImage.setHeight(200);
        assertTrue(200 == defaultImage.getHeight());
    }

    @Test
    public void shouldHaveUrl() {
        assertNull(defaultImage.getUrl());
    }

    @Test
    public void shouldReturnUrlAsSet() {
        defaultImage.setUrl("myUrl");
        assertEquals("myUrl", defaultImage.getUrl());
    }

    @Test
    public void shouldHaveWidth() {
        assertTrue(0 == defaultImage.getWidth());
    }

    @Test
    public void shouldReturnWidthAsSet() {
        defaultImage.setWidth(100);
        assertTrue(100 == defaultImage.getWidth());
    }

}