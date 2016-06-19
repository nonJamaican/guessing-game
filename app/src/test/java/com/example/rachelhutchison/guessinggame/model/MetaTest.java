package com.example.rachelhutchison.guessinggame.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MetaTest {

    private Meta meta;

    @Before
    public void setUp() {
        meta = new Meta();
    }

    @Test
    public void shouldHavePrimaryDocument() {
        assertNull(meta.getPrimaryDocument());
    }

    @Test
    public void shouldReturnPrimaryDocumentsAsSet() {
        meta.setPrimaryDocument("players");
        assertEquals("players", meta.getPrimaryDocument());
    }

    @Test
    public void shouldHavePlayers() {
        assertNull(meta.getPlayers());
    }

    @Test
    public void shouldReturnPlayersAsSet() {
        Players players = new Players();
        meta.setPlayers(players);
        assertEquals(players, meta.getPlayers());
    }
}
