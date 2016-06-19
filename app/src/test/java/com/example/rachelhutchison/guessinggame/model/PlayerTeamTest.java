package com.example.rachelhutchison.guessinggame.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PlayerTeamTest {

    private PlayerTeam team;

    @Before
    public void setUp() {
        team = new PlayerTeam();
    }

    @Test
    public void hasMembers() {
        assertNull(team.getMembers());
    }

    @Test
    public void membersWillReturnAsSet() {
        List<String> members = new ArrayList<>();
        members.add("member");
        team.setMembers(members);
        assertEquals(members, team.getMembers());
    }

    @Test
    public void hasRef() {
        assertNull(team.getRef());
    }

    @Test
    public void refWillReturnAsSet() {
        team.setRef("team.id");
        assertEquals("team.id", team.getRef());
    }

}