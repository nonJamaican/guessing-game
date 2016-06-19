package com.example.rachelhutchison.guessinggame.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class NewsTest {

    private News news;

    @Before
    public void setUp() {
        news = new News();
    }

    @Test
    public void hasLatest() {
        assertNull(news.getLatest());
    }

    @Test
    public void latestWillReturnAsSet() {
        news.setLatest("12345y");
        assertEquals("12345y", news.getLatest());
    }
}