package com.example.rachelhutchison.guessinggame.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class FixtureTest {

    private Fixture fixture;

    @Before
    public void setUp() {
        fixture = new Fixture();
    }

    @Test
    public void shouldHaveAwayTeam() {
        assertNull(fixture.getAwayTeam());
    }

    @Test
    public void shouldReturnAwayTeamAsSet() {
        FixtureTeam team = new FixtureTeam();
        fixture.setAwayTeam(team);
        assertEquals(team, fixture.getAwayTeam());
    }

    @Test
    public void shouldHaveHomeTeam() {
        assertNull(fixture.getHomeTeam());
    }

    @Test
    public void shouldReturnHomeTeamAsSet() {
        FixtureTeam team = new FixtureTeam();
        fixture.setHomeTeam(team);
        assertEquals(team, fixture.getHomeTeam());
    }

    @Test
    public void shouldHaveId() {
        assertNull(fixture.getId());
    }

    @Test
    public void shouldReturnIdAsSet() {
        fixture.setId("23");
        assertEquals("23", fixture.getId());
    }

    @Test
    public void shouldHaveSport() {
        assertNull(fixture.getSport());
    }

    @Test
    public void shouldReturnSportAsSet() {
        fixture.setSport("NBA");
        assertEquals("NBA", fixture.getSport());
    }

    @Test
    public void shouldHaveStartDate() {
        assertNull(fixture.getStartDate());
    }

    @Test
    public void shouldReturnStartDateAsSet() {
        fixture.setStartDate("StartDate");
        assertEquals("StartDate", fixture.getStartDate());
    }

    @Test
    public void shouldHaveStatus() {
        assertNull(fixture.getStatus());
    }

    @Test
    public void shouldReturnStatusAsSet() {
        Object status = new Object();
        fixture.setStatus(status);
        assertEquals(status, fixture.getStatus());
    }
}
