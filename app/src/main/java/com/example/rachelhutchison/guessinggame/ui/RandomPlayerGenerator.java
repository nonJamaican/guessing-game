package com.example.rachelhutchison.guessinggame.ui;

import com.example.rachelhutchison.guessinggame.model.FanDuelPlayers;
import com.example.rachelhutchison.guessinggame.model.Player;

import java.util.List;
import java.util.Random;

public class RandomPlayerGenerator {

    private List<Player> allPlayers;

    public RandomPlayerGenerator(FanDuelPlayers fanDuelPlayersData) {
        allPlayers = fanDuelPlayersData.getPlayers();
    }

    public List<Player> getAllPlayers() {
        return allPlayers;
    }

    public Player getRandomPlayer() {
        return allPlayers.get(getRandomNumber());
    }

    private int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(allPlayers.size());
    }
}
