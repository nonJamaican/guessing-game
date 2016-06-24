package com.example.rachelhutchison.guessinggame.ui;

import com.example.rachelhutchison.guessinggame.model.FanDuelPlayers;
import com.example.rachelhutchison.guessinggame.model.Player;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RandomPlayerGeneratorTest {

    private FanDuelPlayers fanDuelPlayers;
    private RandomPlayerGenerator randomPlayerGenerator;

    @Before
    public void setUp() {
        populateFanDuelPlayers();
        randomPlayerGenerator = new RandomPlayerGenerator(fanDuelPlayers);
    }

    @Test
    public void shouldPopulateAListOfPlayersFromFanDuelData() {
        assertNotNull(randomPlayerGenerator.getAllPlayers());
    }

    @Test
    public void shouldPopulateAListWithAllPlayersFromFanDuelData() {
        assertEquals(5, randomPlayerGenerator.getAllPlayers().size());
    }

    @Test
    public void getRandomPlayerWillNotBeEmpty() {
        assertNotNull(randomPlayerGenerator.getRandomPlayer());
    }

    private void populateFanDuelPlayers() {
        fanDuelPlayers = new FanDuelPlayers();
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            players.add(buildNewPlayer(i));
        }
        fanDuelPlayers.setPlayers(players);
    }

    private Player buildNewPlayer(int count) {
        Player player = new Player();
        player.setFirstName("player" + count);
        player.setFppg(count);
        player.setPlayerCardUrl("something");
        return player;
    }

}