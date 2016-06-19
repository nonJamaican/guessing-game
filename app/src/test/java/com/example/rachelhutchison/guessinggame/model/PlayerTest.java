package com.example.rachelhutchison.guessinggame.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    private Player player;

    @Before
    public void setUp() {
        player = new Player();
    }

    @Test
    public void playerHasAttributeFirstName() {
        assertNull(player.getFirstName());
    }

    @Test
    public void playerFirstNameIsReturnedAsSet() {
        player.setFirstName("my name");
        assertEquals("my name", player.getFirstName());
    }

    @Test
    public void playerHasAttributeFixture() {
        assertNull(player.getPlayerFixture());
    }

}