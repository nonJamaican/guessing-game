package com.example.rachelhutchison.guessinggame.playergenerator;

import com.example.rachelhutchison.guessinggame.model.FanDuelPlayers;
import com.example.rachelhutchison.guessinggame.model.Player;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RandomPlayerGeneratorTest {

    private RandomPlayerGenerator randomPlayerGenerator;

    @Before
    public void setUp() {
        FanDuelPlayers fanDuelPlayers = populate5RandomFanDuelPlayers();
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

    private FanDuelPlayers populate5RandomFanDuelPlayers() {
        FanDuelPlayers fanDuelPlayers = new FanDuelPlayers();
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            players.add(buildNewNumberedPlayer(i));
        }
        fanDuelPlayers.setPlayers(players);
        return fanDuelPlayers;
    }

    private Player buildNewNumberedPlayer(int number) {
        Player player = new Player();
        player.setFirstName("player" + number);
        player.setFppg(number);
        player.setPlayerCardUrl("something");
        return player;
    }
}