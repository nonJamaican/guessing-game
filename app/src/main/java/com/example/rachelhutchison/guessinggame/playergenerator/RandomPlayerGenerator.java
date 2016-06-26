package com.example.rachelhutchison.guessinggame.playergenerator;

import com.example.rachelhutchison.guessinggame.model.FanDuelResponse;
import com.example.rachelhutchison.guessinggame.model.Player;

import java.util.List;
import java.util.Random;

public class RandomPlayerGenerator {

    private List<Player> allPlayers;

    public RandomPlayerGenerator(FanDuelResponse fanDuelResponse) {
        allPlayers = fanDuelResponse.getPlayers();
    }

    public List<Player> getAllPlayers() {
        return allPlayers;
    }

    public Player getRandomPlayer() {
        return allPlayers.get(getRandomNumber());
    }

    private int getRandomNumber() {
        return new Random().nextInt(allPlayers.size());
    }
}
