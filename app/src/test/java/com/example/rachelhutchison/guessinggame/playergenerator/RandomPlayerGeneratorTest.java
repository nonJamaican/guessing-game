package com.example.rachelhutchison.guessinggame.playergenerator;

import com.example.rachelhutchison.guessinggame.model.FanDuelResponse;
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
        FanDuelResponse fanDuelResponse = populate5RandomFanDuelPlayers();
        randomPlayerGenerator = new RandomPlayerGenerator(fanDuelResponse);
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

    private FanDuelResponse populate5RandomFanDuelPlayers() {
        FanDuelResponse fanDuelResponse = new FanDuelResponse();
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            players.add(buildNewNumberedPlayer(i));
        }
        fanDuelResponse.setPlayers(players);
        return fanDuelResponse;
    }

    private Player buildNewNumberedPlayer(int number) {
        Player player = new Player();
        player.setFirstName("player" + number);
        player.setFppg(number);
        player.setPlayerCardUrl("something");
        return player;
    }
}