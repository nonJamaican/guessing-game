package com.example.rachelhutchison.guessinggame.compare;

import com.example.rachelhutchison.guessinggame.model.Player;

public class PlayerComparator {

    public static String getFullNameOfHighestFppgRating(Player player1, Player player2) {
        int compare = Double.compare(getFppgRating(player1), getFppgRating(player2));
        if (compare == 0) {
            return null;
        }
        return getPlayersFullName(compare > 0 ? player1 : player2);
    }

    private static String getPlayersFullName(Player player) {
        return player.getFirstName() + " " + player.getLastName();
    }

    private static Double getFppgRating(Player player) {
        return player.getFppg();
    }
}
