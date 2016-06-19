package com.example.rachelhutchison.guessinggame.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FixtureTeamTest {

    private FixtureTeam fixtureTeam;

    @Before
    public void setUp() {
        fixtureTeam = new FixtureTeam();
    }

    @Test
    public void shouldHaveScore() {
        assertNull(fixtureTeam.getScore());
    }

    @Test
    public void shouldReturnScoreAsSet() {
        Object score = new Object();
        fixtureTeam.setScore(score);
        assertEquals(score, fixtureTeam.getScore());
    }

    @Test
    public void shouldHavePlayerTeam() {
        assertNull(fixtureTeam.getPlayerTeam());
    }

    @Test
    public void shouldReturnPlayerTeamAsSet() {
        PlayerTeam team = new PlayerTeam();
        fixtureTeam.setPlayerTeam(team);
        assertEquals(team, fixtureTeam.getPlayerTeam());
    }

}