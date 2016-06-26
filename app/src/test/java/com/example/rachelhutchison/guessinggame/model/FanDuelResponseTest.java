package com.example.rachelhutchison.guessinggame.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class FanDuelResponseTest {

    private FanDuelResponse fanDuelResponse;

    @Before
    public void setUp() {
        fanDuelResponse = new FanDuelResponse();
    }

    @Test
    public void hasMeta() {
        assertNull(fanDuelResponse.getMeta());
    }

    @Test
    public void metaWillReturnAsSet() {
        Meta meta = new Meta();
        fanDuelResponse.setMeta(meta);
        assertEquals(meta, fanDuelResponse.getMeta());
    }

    @Test
    public void hasFixtures() {
        assertNull(fanDuelResponse.getFixtures());
    }

    @Test
    public void willReturnFixturesAsSet() {
        List<Fixture> fixtures = new ArrayList<>();
        fanDuelResponse.setFixtures(fixtures);
        assertEquals(fixtures, fanDuelResponse.getFixtures());
    }

    @Test
    public void hasPlayers() {
        assertNull(fanDuelResponse.getPlayers());
    }

    @Test
    public void willReturnPlayersAsSet() {
        List<Player> players = new ArrayList<>();
        fanDuelResponse.setPlayers(players);
        assertEquals(players, fanDuelResponse.getPlayers());
    }

    @Test
    public void hasTeams() {
        assertNull(fanDuelResponse.getTeams());
    }

    @Test
    public void willReturnTeamsAsSet() {
        List<Team> teams = new ArrayList<>();
        fanDuelResponse.setTeams(teams);
        assertEquals(teams, fanDuelResponse.getTeams());
    }
}
