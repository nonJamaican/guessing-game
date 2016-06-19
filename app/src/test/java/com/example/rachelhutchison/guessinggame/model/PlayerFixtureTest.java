package com.example.rachelhutchison.guessinggame.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PlayerFixtureTest {

    private PlayerFixture playerFixture;

    @Before
    public void setUp() {
        playerFixture = new PlayerFixture();
    }

    @Test
    public void shouldHaveMembers() {
        assertNull(playerFixture.getMembers());
    }

    @Test
    public void shouldReturnMembersAsSet() {
        List<String> members = new ArrayList<>();
        members.add("123");
        playerFixture.setMembers(members);
        assertEquals(members, playerFixture.getMembers());
    }

    @Test
    public void shouldHaveRef() {
        assertNull(playerFixture.getRef());
    }

    @Test
    public void shouldReturnRefAsSet() {
        playerFixture.setRef("reference");
        assertEquals("reference", playerFixture.getRef());
    }

}