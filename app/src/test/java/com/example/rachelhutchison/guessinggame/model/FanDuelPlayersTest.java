package com.example.rachelhutchison.guessinggame.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class FanDuelPlayersTest {

    private FanDuelPlayers fanDuelPlayers;

    @Before
    public void setUp() {
        fanDuelPlayers = new FanDuelPlayers();
    }

    @Test
    public void hasMeta() {
        assertNull(fanDuelPlayers.getMeta());
    }

    @Test
    public void metaWillReturnAsSet() {
        Meta meta = new Meta();
        fanDuelPlayers.setMeta(meta);
        assertEquals(meta, fanDuelPlayers.getMeta());
    }

    @Test
    public void hasFixtures() {
        assertNull(fanDuelPlayers.getFixtures());
    }

    @Test
    public void willReturnFixturesAsSet() {
        List<Fixture> fixtures = new ArrayList<>();
        fanDuelPlayers.setFixtures(fixtures);
        assertEquals(fixtures, fanDuelPlayers.getFixtures());
    }

    @Test
    public void hasPlayers() {
        assertNull(fanDuelPlayers.getPlayers());
    }

    @Test
    public void willReturnPlayersAsSet() {
        List<Player> players = new ArrayList<>();
        fanDuelPlayers.setPlayers(players);
        assertEquals(players, fanDuelPlayers.getPlayers());
    }

    @Test
    public void hasTeams() {
        assertNull(fanDuelPlayers.getTeams());
    }

    @Test
    public void willReturnTeamsAsSet() {
        List<Team> teams = new ArrayList<>();
        fanDuelPlayers.setTeams(teams);
        assertEquals(teams, fanDuelPlayers.getTeams());
    }
}
