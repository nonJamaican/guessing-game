package com.example.rachelhutchison.guessinggame.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void playerFixtureIsReturnedAsSet() {
        PlayerFixture playerFixture = new PlayerFixture();
        player.setPlayerFixture(playerFixture);
        assertEquals(playerFixture, player.getPlayerFixture());
    }

    @Test
    public void playerHasFPPG() {
        assertTrue(0.0 == player.getFppg());
    }

    @Test
    public void playerFPPGIsReturnedAsSet() {
        double fppg = 38.5974025974026;
        player.setFppg(fppg);
        assertTrue(fppg == player.getFppg());
    }

    @Test
    public void playerHasId() {
        assertNull(player.getId());
    }

    @Test
    public void playersIdIsReturnedAsSet() {
        player.setId("123-123");
        assertEquals("123-123", player.getId());
    }

    @Test
    public void playerHasAttributeImages() {
        assertNull(player.getImages());
    }

    @Test
    public void imagesWillReturnAsSet() {
        PlayerImage image = new PlayerImage();
        player.setImages(image);
        assertEquals(image, player.getImages());
    }

    @Test
    public void hasAttributeInjured() {
        assertFalse(player.getInjured());
    }

    @Test
    public void injuredWillReturnAsSet() {
        player.setInjured(true);
        assertTrue(player.getInjured());
    }

    @Test
    public void playerHasAttributeInjuryDetails() {
        assertNull(player.getInjuryDetails());
    }

    @Test
    public void playerInjuryDetailsIsReturnedAsSet() {
        player.setInjuryDetails("calf");
        assertEquals("calf", player.getInjuryDetails());
    }

    @Test
    public void playerHasAttributeInjuryStatus() {
        assertNull(player.getInjuryStatus());
    }

    @Test
    public void playerInjuryStatusIsReturnedAsSet() {
        player.setInjuryStatus("o");
        assertEquals("o", player.getInjuryStatus());
    }

    @Test
    public void playerHasPlayedCount() {
        assertTrue(0 == player.getPlayed());
    }

    @Test
    public void playedWillReturnAsSet() {
        player.setPlayed(53);
        assertTrue(53 == player.getPlayed());
    }

    @Test
    public void playerHasPlayerCardUrl() {
        assertNull(player.getPlayerCardUrl());
    }

    @Test
    public void playerCardUrlWillReturnAsSet() {
        player.setPlayerCardUrl("myCardUrl");
        assertEquals("myCardUrl", player.getPlayerCardUrl());
    }

    @Test
    public void playerHasPosition() {
        assertNull(player.getPosition());
    }

    @Test
    public void positionWillReturnAsSet() {
        player.setPosition("PF");
        assertEquals("PF", player.getPosition());
    }

    @Test
    public void playerHasRemoved() {
        assertFalse(player.getRemoved());
    }

    @Test
    public void removedWillReturnAsSet() {
        player.setRemoved(true);
        assertTrue(player.getRemoved());
    }

    @Test
    public void playerHasSalary() {
        assertTrue(0 == player.getSalary());
    }

    @Test
    public void salaryWillReturnAsSet() {
        player.setSalary(7000);
        assertTrue(7000 == player.getSalary());
    }

    @Test
    public void playerWillHaveStartingOrder() {
        assertNull(player.getStartingOrder());
    }

    @Test
    public void startingOrderWillReturnAsSet() {
        Object order = new Object();
        player.setStartingOrder(order);
        assertEquals(order, player.getStartingOrder());
    }

    @Test
    public void playerHasTeam() {
        assertNull(player.getPlayerTeam());
    }

    @Test
    public void playerTeamWillReturnAsSet() {
        PlayerTeam team = new PlayerTeam();
        player.setPlayerTeam(team);
        assertEquals(team, player.getPlayerTeam());
    }

    @Test
    public void playerHasLastName() {
        assertNull(player.getLastName());
    }

    @Test
    public void lastNameWillReturnAsSet() {
        player.setLastName("Richardson");
        assertEquals("Richardson", player.getLastName());
    }

    @Test
    public void hasNews() {
        assertNull(player.getNews());
    }

    @Test
    public void newsWillReturnAsSet() {
        News news = new News();
        player.setNews(news);
        assertEquals(news, player.getNews());
    }
}