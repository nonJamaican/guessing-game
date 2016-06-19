package com.example.rachelhutchison.guessinggame.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TeamTest {

    private Team team;

    @Before
    public void setUp() {
        team = new Team();
    }

    @Test
    public void hasCity() {
        assertNull(team.getCity());
    }

    @Test
    public void cityWillReturnAsSet() {
        team.setCity("city");
        assertEquals("city", team.getCity());
    }

    @Test
    public void hasCode() {
        assertNull(team.getCode());
    }

    @Test
    public void codeWillReturnAsSet() {
        team.setCode("Code");
        assertEquals("Code", team.getCode());
    }

    @Test
    public void hasFullName() {
        assertNull(team.getFullName());
    }

    @Test
    public void fullNameWillReturnAsSet() {
        team.setFullName("FullName");
        assertEquals("FullName", team.getFullName());
    }

    @Test
    public void hasId() {
        assertNull(team.getId());
    }

    @Test
    public void idWillReturnAsSet() {
        team.setId("Id");
        assertEquals("Id", team.getId());
    }

    @Test
    public void hasName() {
        assertNull(team.getName());
    }

    @Test
    public void nameWillReturnAsSet() {
        team.setName("Name");
        assertEquals("Name", team.getName());
    }
}
