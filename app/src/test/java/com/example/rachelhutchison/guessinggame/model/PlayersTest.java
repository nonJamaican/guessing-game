package com.example.rachelhutchison.guessinggame.model;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PlayersTest {

    @Test
    public void hasCount() {
        Players players = new Players();
        assertTrue(0 == players.getCount());
    }

    @Test
    public void countWillReturnAsSet() {
        Players players = new Players();
        players.setCount(34);
        assertTrue(34 == players.getCount());
    }

}